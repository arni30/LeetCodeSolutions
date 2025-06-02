package com.oarnopolin.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            StringBuilder substring = new StringBuilder();
//            int max = 0;
//            for (Character symbol : s.toCharArray()) {
//                int index = substring.indexOf(symbol.toString());
//                if (index != -1) {
//                    if (index != substring.length() - 1) {
//                        substring = new StringBuilder(substring.substring(index + 1));
//                    } else {
//                        substring = new StringBuilder();
//                    }
//                }
//                substring.append(symbol);
//                max = Math.max(substring.length(), max);
//            }
//            return max;
//        }
        // two pointers approach

        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int maxLength = 0;
            Set<Character> uniqueChars = new HashSet<>();
            while (right < s.length()) {
                if (uniqueChars.add(s.charAt(right))) {
                    maxLength = Math.max(maxLength, right - left + 1);
                    right++;
                } else {
                    uniqueChars.remove(s.charAt(left));
                    left++;
                }
            }
            return maxLength;
        }
    }

}
