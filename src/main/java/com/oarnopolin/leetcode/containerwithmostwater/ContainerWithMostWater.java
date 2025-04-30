package com.oarnopolin.leetcode.containerwithmostwater;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 8, 5, 7}));
        System.out.println(solution.maxArea(new int[]{1, 1}));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                int width = right - left;
                int minHeight = Math.min(height[left], height[right]);
                int currentArea = width * minHeight;
                maxArea = Math.max(maxArea, currentArea);
                System.out.printf("left i: %d, right i: %d, width: %d, left v: %d, right v:%d, area: %d%n", left, right, width, height[left], height[right], currentArea);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
// Not effective solution
//        public int maxArea(int[] height) {
//            int max = 0;
//            for (int left = 0; left < height.length; left++) {
//                for (int right = left + 1; right < height.length; right++) {
//                    max = Math.max(Math.min(height[right], height[left]) * (right - left), max);
//                }
//            }
//            return max;
//        }
    }
}
