package com.oarnopolin.leetcode.addtwonumbers;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public class AddTwoNumbers {
    public static void main(String[] args) {


        var solution = new Solution();

        ListNode l2 = solution.createListFromDigits(new BigInteger("1000000000000000000000000000001"));
        ListNode l1 = solution.createListFromDigits(new BigInteger("465"));
        ListNode res = solution.addTwoNumbers(l1, l2);
        StringBuilder resString = new StringBuilder();

        while (res != null) {
            res = solution.appendListNumber(res, resString);
        }

        System.out.println(resString.toString());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder numberString1 = new StringBuilder();
            StringBuilder numberString2 = new StringBuilder();

            while (l1 != null || l2 != null) {
                l1 = appendListNumber(l1, numberString1);
                l2 = appendListNumber(l2, numberString2);
            }

            BigInteger sum = new BigInteger(numberString1.toString()).add(new BigInteger(numberString2.toString()));


            return createListFromDigits(sum);
        }

        public ListNode createListFromDigits(BigInteger number) {
            ListNode resultList = null;
            for (int digit : splitToDigitsList(number)) {
                resultList = new ListNode(digit, resultList);
            }
            return resultList;
        }

        public ListNode appendListNumber(ListNode listNode, StringBuilder builder) {
            return Optional.ofNullable(listNode).map(node -> {
                builder.insert(0, node.val);
                return node.next;
            }).orElse(null);
        }

        public List<Integer> splitToDigitsList(BigInteger sum) {
            return sum.toString().chars().mapToObj(Character::getNumericValue).toList();
        }
    }
}