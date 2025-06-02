package com.oarnopolin.leetcode.linkedlistcycle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {
        var solution = new Solution();
        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Connect nodes: 3 -> 2 -> 0 -> -4 -> points back to node2
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // creates cycle

        boolean hasCycle = solution.hasCycle(node1);
        System.out.println("Has cycle: " + hasCycle);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {

        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                if (slow == fast) return true;

                slow = slow.next;
                fast = fast.next.next;
            }

            return false;
        }
    }

}
