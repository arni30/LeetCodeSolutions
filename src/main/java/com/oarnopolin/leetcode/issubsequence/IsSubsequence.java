package com.oarnopolin.leetcode.issubsequence;

public class IsSubsequence {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
        System.out.println(solution.isSubsequence("", "ahbgdc"));
        System.out.println(solution.isSubsequence("b", "c"));
        System.out.println(solution.isSubsequence("aza", "abzba"));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;

            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }

            return i == s.length();
        }
    }
}
