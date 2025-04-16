package com.oarnopolin.leetcode.palindromenumber;

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:
-231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?
 */

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int result = 0;
            int temp = x;
            while (temp != 0) {
                int digit = temp % 10;
                result = result * 10 + digit;
                temp = temp / 10;
            }
            System.out.println(result);
            System.out.println(x);
            return result == x;
        }
    }
}
