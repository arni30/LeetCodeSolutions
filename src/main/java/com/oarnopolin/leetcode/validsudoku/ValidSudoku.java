package com.oarnopolin.leetcode.validsudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        // Example Sudoku board (valid)
        char[][] validBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '6', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solution = new Solution();
        System.out.println("Is the Sudoku board valid? " + solution.isValidSudoku(validBoard));
        System.out.println("Is the Sudoku board valid? " + solution.isValidSudoku(invalidBoard));

    }
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                Set<Character> row = new HashSet<>();
                Set<Character> col = new HashSet<>();
                Set<Character> square = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    if (
                            validateElement(board[i][j], row) // validate row
                                    || validateElement(board[j][i], col)  // validate column
                                    || validateElement(board[3 * (i / 3) + (j / 3)][3 * (i % 3) + (j % 3)], square) // validate square
                    ) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean validateElement(char elem, Set<Character> part) {
            return elem != '.' && !part.add(elem);
        }
    }

//    static class Solution {
//        public boolean isValidSudoku(char[][] board) {
//            for (int i = 0; i < 9; i++) {
//                Set<Character> row = new HashSet<>();
//                Set<Character> col = new HashSet<>();
//                Set<Character> square = new HashSet<>();
//                for (int j = 0; j < 9; j++) {
//                    //validating rows
//                    if (board[i][j] != '.' && !row.add(board[i][j])) {
//                        return false;
//                    }
//                    //validating rows
//                    if (board[j][i] != '.' && !col.add(board[j][i])) {
//                        return false;
//                    }
//                    //validating squares
//                    int squareI = 3 * (i / 3) + (j / 3);
//                    int squareJ = 3 * (i % 3) + (j % 3);
//                    if (board[squareI][squareJ] != '.' && !square.add(board[squareI][squareJ])) {
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//
//        private boolean validateElement(char elem, Set<Character> part) {
//            return elem == '.' || part.add(elem);
//        }
//    }
}
