package com.oarnopolin.leetcode.findtheindexofthefirstoccurrenceinastring;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("ssadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "leeto"));
        System.out.println(solution.strStr("abc", "c"));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int k = needle.length();
            for (int left = 0; left <= n - k; left++) {
                int right = 0;
                boolean flag = true;
                while (right < k) {
                    if (needle.charAt(right) != haystack.charAt(left + right)) {
                        flag = false;
                        break;
                    }
                    right++;
                }
                if (flag) {
                    return left;
                }
            }
            return -1;
        }
    }
}
