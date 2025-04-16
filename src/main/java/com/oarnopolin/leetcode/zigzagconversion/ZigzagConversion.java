package com.oarnopolin.leetcode.zigzagconversion;

import java.util.*;
import java.util.stream.Collectors;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
        System.out.println(solution.convert("a", 1));
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1 || s.length() <= numRows) {
                return s;
            }
            List<StringBuilder> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                result.add(new StringBuilder());
            }

            int count = 0;
            boolean goingUp = false;
            for (char c : s.toCharArray()) {
                result.get(count).append(c);
                if (count == 0 || count == numRows - 1) {
                    goingUp = !goingUp;
                }
                count += goingUp ? 1 : -1;
            }

            return result.stream().map(StringBuilder::toString).collect(Collectors.joining());
        }
// Not effective solution
//        public String convert(String s, int numRows) {
//            char[] chars = s.toCharArray();
//            String res = "";
//            if (numRows == 1) {
//                return s;
//            }
//            for (int i = 0; i < numRows; i++) {
//                int step;
//                if (i % (numRows - 1) == 0) {
//                    step = 2 * (numRows - 1);
//                    for (int j = i; j < s.length(); j += step) {
//                        res += chars[j];
//                    }
//                } else if (numRows % 2 != 0 && i == numRows / 2) {
//                    step = numRows - 1;
//                    for (int j = i; j < s.length(); j += step) {
//                        res += chars[j];
//                    }
//                } else {
//                    step = 2 * (numRows - 1);
//                    for (int j = i; j < s.length(); j += step) {
//                        res += chars[j];
//                        if (j + step - i * 2 < s.length()) {
//                            res += chars[j + step - i * 2];
//                        }
//                    }
//                }
//            }
//            return res;
//        }
    }
}
