package com.oarnopolin.leetcode.rotateimage;

public class RotateImage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix1);
        solution.rotate(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        printMatrix(matrix2);
        solution.rotate(matrix2);
        printMatrix(matrix2);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            for (int i = 0; i < n; i++) {
                // Transpose matrix
                for (int j = i + 1; j < n; j++) {
                    matrix[i][j] ^= matrix[j][i];
                    matrix[j][i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[j][i];
                }
                // Reverse matrix rows
                for (int j = 0; j < n / 2; j++) {
                    matrix[i][j] ^= matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[i][n - 1 - j];
                }
            }
        }
    }
}
