package com.oarnopolin.leetcode.longestcommonprefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"reflower","flow","flight"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            String result = "";
            for (char c : strs[0].toCharArray()) {

                boolean isSubstring = true;
                for (String s : strs) {
                    if (!s.startsWith(result + c)) {
                        isSubstring = false;
                        break;
                    }
                }
                if (isSubstring) {
                    result += c;
                }
            }
            return result;
        }
    }
}
