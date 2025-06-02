package com.oarnopolin.leetcode.maximumdepthofbinarytree;

import java.util.Map;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        // Create the binary tree:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);

        Solution solution = new Solution();
        int depth = solution.maxDepth(root);
        System.out.println("Max depth of the tree: " + depth);
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
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
