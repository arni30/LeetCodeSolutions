package com.oarnopolin.leetcode.mergetwosortedlists;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.
    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: list1 = [], list2 = []
    Output: []

    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]

    Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {


        var solution = new Solution();

        ListNode l2 = solution.createListFromDigits(new BigInteger("124"));
        ListNode l1 = solution.createListFromDigits(new BigInteger("123"));
        ListNode res = solution.mergeTwoLists(l1, l2);
        StringBuilder resString = new StringBuilder();

        while (res != null) {
            res = solution.appendListNumber(res, resString);
        }

        System.out.println(resString.toString());

    }
}

class ListNode {
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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode();
        ListNode start = current;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;
        return start.next;
    }

    public ListNode createListFromDigits(BigInteger number) {
        ListNode resultList = null;
        for (int digit : splitToDigitsList(number)) {
            resultList = new ListNode(digit, resultList);
        }
        return resultList;
    }

    public List<Integer> splitToDigitsList(BigInteger sum) {
        return sum.toString().chars().mapToObj(Character::getNumericValue).toList();
    }


    public ListNode appendListNumber(ListNode listNode, StringBuilder builder) {
        return Optional.ofNullable(listNode).map(node -> {
            builder.insert(0, node.val);
            return node.next;
        }).orElse(null);
    }
}