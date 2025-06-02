package com.oarnopolin.leetcode.minimumsizesubarraysum;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int right = 0;
            int left = 0;
            int sum = 0;
            int minLength = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right];
                while (sum >= target) {
                    minLength = Math.min(minLength, right - left + 1);
                    sum -= nums[left++];
                }
                right++;
            }
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }
}
