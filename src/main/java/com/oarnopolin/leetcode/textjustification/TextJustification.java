package com.oarnopolin.leetcode.textjustification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        var solution = new Solution();
        solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).forEach(System.out::println);
        ;
//        System.out.println(solution.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
//        solution.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20).forEach(System.out::println);
//        System.out.println(solution.fullJustify(new String[]{"shall", "be"}, 16));
    }

    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int start = 0;
            int end = 0;
            int len = 0;
            List<String> result = new ArrayList<>();
            while (end < words.length) {
                if (len + words[end].length() + end - start <= maxWidth) {
                    len += words[end].length();
                    end++;
                } else {
                    StringBuilder line = new StringBuilder();
                    if (end - start > 1) {
                        int spaceCount = (maxWidth - len) / (end - start - 1);
                        int additionalSpaces = (maxWidth - len) % (end - start - 1);
                        while (start < end) {
                            line.append(words[start]);
                            if (end - start > 1) {
                                if (additionalSpaces > 0) {
                                    line.append(" ".repeat(Math.max(0, spaceCount + 1)));
                                    additionalSpaces--;
                                } else {
                                    line.append(" ".repeat(Math.max(0, spaceCount)));
                                }
                            }
                            start++;
                        }
                    } else {
                        int spaceCount = (maxWidth - len);
                        line.append(words[start]);
                        line.append(" ".repeat(Math.max(0, spaceCount)));
                        start++;
                    }
                    len = 0;
                    result.add(line.toString());

                }
            }
            StringBuilder line = new StringBuilder();
            while (start < end) {
                line.append(words[start]);
                if (end - start > 1) {
                    line.append(" ");
                    len++;
                }
                start++;
            }
            line.append(" ".repeat(Math.max(0, maxWidth - len)));
            result.add(line.toString());
            return result;
        }
    }
}
