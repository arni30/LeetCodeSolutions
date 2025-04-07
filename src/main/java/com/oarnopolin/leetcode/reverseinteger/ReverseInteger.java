package com.oarnopolin.leetcode.reverseinteger;


/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21


Constraints:
-231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(900000));
    }

    static class Solution {
        public int reverse(int x) {
            int result = 0;
            while (x != 0) {
                int digit = x % 10;
                if (result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE / 10 && digit > 7)) return 0; // 7 is the lust digit in MAX_INT
                if (result < Integer.MIN_VALUE / 10 ||
                        (result == Integer.MIN_VALUE / 10 && digit < -8)) return 0; // -8 is the lust digit in MINT_INT
                result = result * 10 + digit;
                x = x / 10;
            }
            return result;
        }
    }
}