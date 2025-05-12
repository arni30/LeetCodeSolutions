package com.oarnopolin.leetcode.longestpalindromicsubstring;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            for (int left = 0; left < s.length(); left++) {
                int right = s.length() - 1;
                while (left < right) {
                    System.out.printf("left: %s, right: %s\n", chars[left], chars[right]);
                    if (chars[left] != chars[right]) {
                        right = s.length() - left;
                        continue;
                    }
                    right--;
                }
            }
            return "";
        }
    }
}
