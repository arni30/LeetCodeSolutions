package com.oarnopolin.leetcode.medianoftwosortedarrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2,4};

        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // Ensure nums1 is the smaller array
            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int low = 0, high = m;

            while (low <= high) {
                int partitionL = (low + high) / 2;
                int partitionR = (m + n + 1) / 2 - partitionL;

                // If partitionX is 0 it means nothing is there on left side. Use Integer.MIN_VALUE for maxLeft
                // If partitionX is length of array then there is nothing on right side. Use Integer.MAX_VALUE for minRight
                int maxL = (partitionL == 0) ? Integer.MIN_VALUE : nums1[partitionL - 1];
                int minL = (partitionL == m) ? Integer.MAX_VALUE : nums1[partitionL];

                int maxR = (partitionR == 0) ? Integer.MIN_VALUE : nums2[partitionR - 1];
                int minR = (partitionR == n) ? Integer.MAX_VALUE : nums2[partitionR];

                if (maxL <= minR && maxR <= minL) {
                    // Correct partition
                    if ((m + n) % 2 == 0) {
                        return ((double) Math.max(maxL, maxR) + Math.min(minL, minR)) / 2;
                    } else {
                        return (double) Math.max(maxL, maxR);
                    }
                } else if (maxL > minR) {
                    // Too far on right, move left
                    high = partitionL - 1;
                } else {
                    // Too far on left, move right
                    low = partitionL + 1;
                }
            }
            throw new IllegalArgumentException("Input arrays are not sorted.");
        }
//        Not Effective solution
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
//            System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
//            Arrays.sort(result);
//            if (result.length % 2 != 0) {
//                return result[(result.length / 2)];
//            } else {
//                return (double) (result[result.length / 2] + result[result.length / 2 - 1]) / 2;
//            }
//        }
    }
}
