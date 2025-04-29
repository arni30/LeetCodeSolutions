package com.oarnopolin.leetcode.countsubarrayswheremaxelementappearsatleastktimes;

/*
You are given an integer array nums and a positive integer k.
Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
A subarray is a contiguous sequence of elements within an array.

Example 1:
Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].

Example 2:
Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= k <= 105
 */

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(new int[]{1, 3, 2, 3, 3}, 3));
        System.out.println(solution.countSubarrays(new int[]{1, 4, 2, 1}, 3));
    }

    static class Solution {
        public long countSubarrays(int[] nums, int k) {
            int max = nums[0];
            int n = nums.length;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            long result = 0;
            int count = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                if (nums[right] == max) {
                    count++;
                }
                // count = 2, right = 3, left = 0, result = 2
                // count = 2, right = 3, left = 1, result = 4
                // count = 2, right = 4, left = 2, result = 5
                // count = 2, right = 4, left = 3, result = 6
                while (count >= k) {
                    result += n - right;
                    if (nums[left] == max) {
                        count--;
                    }
                    left++;
                }
            }
            return result;
        }
        //Not effective solution
//        public long countSubarrays(int[] nums, int k) {
//            int max = nums[0];
//            for (int num : nums) {
//                max = Math.max(num, max);
//            }
//            int result = 0;
//            for (int i = 0; i < nums.length; i++) {
//                int tempCount = 0;
//                for (int j = i; j < nums.length; j++) {
//                    if (nums[j] == max) {
//                        tempCount++;
//                    }
//                    if (tempCount >= k) {
//                        result++;
//                    }
//                }
//            }
//            return result;
//        }
    }
}
