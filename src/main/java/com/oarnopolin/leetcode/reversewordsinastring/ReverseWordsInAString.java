package com.oarnopolin.leetcode.reversewordsinastring;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello   world  "));
        System.out.println(solution.reverseWords("F R  I   E    N     D      S      "));
        System.out.println(solution.reverseWords("   fffff ff gg ee"));
    }

    static class Solution {
//        public String reverseWords(String s) {
//            return String.join(" ", Arrays.stream(s.trim().split("\\s+")).toList().reversed());
//        }

        // Solution without streams
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;
            char leftSymbol = chars[left];
            char rightSymbol = chars[right];
            int count = 0;
            while (leftSymbol == ' ' || rightSymbol == ' ') {
                leftSymbol = chars[left];
                rightSymbol = chars[right];
                if (chars[left] == ' ') {
                    left++;
                    count++;
                }
                if (chars[right] == ' ') {
                    right--;
                    count++;
                }
            }
            int write = 0;
            for (int i = left; i <= right; i++) {
                if (s.charAt(i) != ' ' || (i != right && s.charAt(i) == ' ' && s.charAt(i + 1) != ' ')) {
                    chars[write++] = chars[i];
                } else {
                    count++;
                }
            }
            for (int i = 0, j = s.length() - count - 1; i < j; i++, j--) {
                chars[i] ^= chars[j];
                chars[j] ^= chars[i];
                chars[i] ^= chars[j];
            }
            int start = 0;
            for (int i = 0; i < s.length() - count; i++) {
                if (chars[i] == ' ' || i == s.length() - count - 1) {
                    int end = i == s.length() - count - 1 ? i : i - 1;
                    while (start < end) {
                        chars[start] ^= chars[end];
                        chars[end] ^= chars[start];
                        chars[start++] ^= chars[end--];
                    }
                    start = i + 1;
                }
            }
            return new String(chars, 0, s.length() - count);
        }
    }
}
