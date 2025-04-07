package com.oarnopolin.leetcode.validparentheses;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String test = "){";
        Solution solution = new Solution();
//        solution.isValid(test);
        System.out.println(solution.isValid(test));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            if (s.length() % 2 != 0) return false;
            for (Character c : s.toCharArray()) {
                if ("({[".contains(c.toString())) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    char lastElement = stack.pop();
                    if (lastElement + 1 != c && lastElement + 2 != c) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}