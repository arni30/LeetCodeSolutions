package com.oarnopolin.leetcode.firstmissingpositive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FirstMissingPositive {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(solution.firstMissingPositive(new int[]{100000, 3, 4000, 2, 15, 1, 99999}));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Step 1: Place each number in its correct position
            for (int i = 0; i < n; i++) {
                while (
                        nums[i] > 0 && nums[i] <= n &&
                                nums[nums[i] - 1] != nums[i]
                ) {
                    // Swap nums[i] with nums[nums[i] - 1]
                    int correctIndex = nums[i] - 1;
                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
                }
            }
            System.out.println(Arrays.toString(nums));

            // Step 2: Find the first missing positive
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            // All values are in place (1 to n)
            return n + 1;
        }
//        Not effective solution
//        public int firstMissingPositive(int[] nums) {
//            Arrays.sort(nums);
//            System.out.println(Arrays.toString(nums));
//            Integer[] boxedArray = Arrays.stream(nums).filter(num -> num > 0).boxed().toArray(Integer[]::new);
//            Set<Integer> uniqueNums = new TreeSet<>(Arrays.asList(boxedArray));
//            int notPresent = 1;
//            for (int num : uniqueNums) {
//                if (num != notPresent) {
//                    return notPresent;
//                } else {
//                    notPresent++;
//                }
//            }
//            return notPresent;
//        }
    }
}
