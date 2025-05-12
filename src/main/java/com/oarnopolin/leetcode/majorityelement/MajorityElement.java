package com.oarnopolin.leetcode.majorityelement;

public class MajorityElement {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int candidate = nums[0];
            int count = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            return candidate;
        }
    }
}
