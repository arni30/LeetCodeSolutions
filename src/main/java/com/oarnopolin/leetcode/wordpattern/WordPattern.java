package com.oarnopolin.leetcode.wordpattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordPattern {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("aba", "cat cat cat dog"));
        System.out.println(solution.wordPattern("aaa", "aa aa aa aa"));
        System.out.println(solution.wordPattern("e", "eukera"));
    }

    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            char[] chars = pattern.toCharArray();
            if (chars.length != words.length) {
                return false;
            }
            Map<Character, String> wordsMap = new HashMap<>();
//            System.out.println(Arrays.toString(chars));
//            System.out.println(Arrays.toString(words));
            for (int i = 0; i < words.length; i++) {
                if (!wordsMap.containsValue(words[i])) {
                    wordsMap.put(chars[i], words[i]);
                }
            }
//                System.out.println(wordsMap);
            for (int i = 0; i < words.length; i++) {
                var val = wordsMap.get(chars[i]);
                if (val == null || !val.equals(words[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
