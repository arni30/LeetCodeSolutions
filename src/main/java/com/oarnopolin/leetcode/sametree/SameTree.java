package com.oarnopolin.leetcode.sametree;

import com.oarnopolin.leetcode.maximumdepthofbinarytree.MaximumDepthOfBinaryTree;

public class SameTree {

    public static void main(String[] args) {
        // Create the binary tree:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode node12 = new TreeNode(1);
        TreeNode node13 = new TreeNode(3);
        TreeNode node11 = new TreeNode(1, node12, node13);

        Solution solution = new Solution();
        boolean same = solution.isSameTree(node1, node11);
        System.out.println("Trees are same: " + same);
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;  // add this check
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
