package com.oarnopolin.leetcode.spiralmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(solution.spiralOrder(new int[][]{{2, 3}}));
        System.out.println(solution.spiralOrder(new int[][]{{7}, {9}, {6}}));
        System.out.println(solution.spiralOrder(new int[][]{{2, 5, 8}, {4, 0, -1}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}}));
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int top = 0;
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;
            int left = 0;
            List<Integer> result = new ArrayList<>();
            while (top <= bottom && left <= right) {
                for (int col = left; col <= right; col++) {
                    result.add(matrix[top][col]);
                }
                top++;
                for (int row = top; row <= bottom; row++) {
                    result.add(matrix[row][right]);
                }
                right--;

                if (top <= bottom) {
                    for (int col = right; col >= left; col--) {
                        result.add(matrix[bottom][col]);
                    }
                }
                bottom--;

                if (left <= right) {
                    for (int row = bottom; row >= top; row--) {
                        result.add(matrix[row][left]);
                    }
                }
                left++;
            }
            return result;
        }
    }
}
