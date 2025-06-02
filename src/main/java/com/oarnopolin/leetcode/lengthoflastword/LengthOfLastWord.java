package com.oarnopolin.leetcode.lengthoflastword;

import java.util.Arrays;

public class LengthOfLastWord {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));
    }

    static class Solution {
//        public int lengthOfLastWord(String s) {
//            return Arrays.stream(s.trim().split("\\s+")).toList().getLast().length();
//        }

        // Without streams solution
        public int lengthOfLastWord(String s) {
            int length = 0;
            int i = s.length() - 1;

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            while (i >= 0 && s.charAt(i) != ' ') {
                length++;
                i--;
            }

            return length;
        }
    }
}
