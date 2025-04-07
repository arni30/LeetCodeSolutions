package com.oarnopolin.leetcode.reversestring;

/*
    Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]

    Example 2:
    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]

    Constraints:
    1 <= s.length <= 105
    s[i] is a printable ascii character.
 */
public class ReverseString {
    public static void main(String[] args) {
//        char[] string = new char[]{'a', 'b', 'c', 'd'};
        char[] string = new char[]{'s', 'a', 's', 'h', 'a'};
        Solution solution = new Solution();
        System.out.println(string);
        solution.reverseString(string);
        System.out.println(string);
    }

    static class Solution {
        public void reverseString(char[] s) {
            for (int i = 0, j = s.length - 1; i < j; i++, j--) {
//          A ^ A = 0 (XORing a number with itself gives 0)
//          A ^ 0 = A (XORing a number with 0 gives the number itself)
//          A ^ B ^ A = B (Order doesn't matter in XOR)
                s[i] ^= s[j];
                s[j] ^= s[i];
                s[i] ^= s[j];
            }
        }
    }
}