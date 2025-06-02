package com.oarnopolin.leetcode.validpalindrome;

public class ValidPalindrome {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(" "));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if (!Character.isLetterOrDigit(leftChar)) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(rightChar)) {
                    right--;
                    continue;
                }
                if (Character.toLowerCase(rightChar) != Character.toLowerCase(leftChar)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
