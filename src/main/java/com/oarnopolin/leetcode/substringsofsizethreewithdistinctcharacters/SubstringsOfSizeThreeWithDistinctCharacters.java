package com.oarnopolin.leetcode.substringsofsizethreewithdistinctcharacters;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.countGoodSubstrings("xyzzaz"));
        System.out.println(solution.countGoodSubstrings("aababcabc"));
    }

    static class Solution {
        public int countGoodSubstrings(String s) {
            char[] sArr = s.toCharArray();
            int result = 0;
            int left = 0;
            final int k = 3;
            List<Character> db = new ArrayList<>();
            for (int right = 0; right < s.length(); right++) {
                char rightChar = sArr[right];
                db.add(rightChar);
                if (right - left == k - 1) {
                    if (new HashSet<>(db).size() == 3) {
                        result++;
                    }
                    System.out.println(db);
                    db.removeFirst();
                    left++;
                }
            }
            return result;
        }
//        public int countGoodSubstrings(String s) {
//            char[] sArr = s.toCharArray();
//            int result = 0;
//            int left = 0;
//            final int k = 3;
//            HashMap<Character, Integer> db = new HashMap<>();
//            for (int right = 0; right < s.length(); right++) {
//                char rightChar = sArr[right];
//                if (db.containsKey(rightChar)) {
//                    db.put(rightChar, db.get(rightChar) + 1);
//                } else {
//                    db.put(rightChar, 1);
//                }
//                if (right - left == k - 1) {
//                    char leftChar = sArr[left];
//                    if (db.size() == 3) {
//                        result++;
//                    }
//                    int newValue = db.getOrDefault(leftChar, 0) - 1;
//
//                    if (newValue == 0) {
//                        db.remove(leftChar);
//                    } else {
//                        db.put(leftChar, newValue);
//                    }
//                    left++;
//                }
//            }
//            return result;
//        }
    }
}
