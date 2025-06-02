package com.oarnopolin.leetcode.threesum;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i <= nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        do {
                            left++;
                        }
                        while (left < right && nums[left] == nums[left - 1]);
                        do {
                            right--;
                        }
                        while (left < right && nums[right] == nums[right + 1]);
                    }
                }
            }
            return result;
        }
    }
}
