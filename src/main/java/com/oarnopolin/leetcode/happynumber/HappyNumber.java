package com.oarnopolin.leetcode.happynumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }

    static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();

            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                int sum = 0;
                while (n > 0) {
                    int digit = n % 10;
                    sum += digit * digit;
                    n /= 10;
                }
                n = sum;
            }
            return n == 1;
        }
    }
}
