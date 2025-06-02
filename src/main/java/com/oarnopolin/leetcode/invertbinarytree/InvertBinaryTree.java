package com.oarnopolin.leetcode.invertbinarytree;

public class InvertBinaryTree {
    public static void main(String[] args) {
        // Construct the binary tree:
        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9

        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node7 = new TreeNode(7, node6, node9);
        TreeNode root = new TreeNode(4, node2, node7);

        System.out.println("Original tree:");
        printTree(root, 0);

        Solution solution = new Solution();
        TreeNode invertedRoot = solution.invertTree(root);

        System.out.println("\nInverted tree:");
        printTree(invertedRoot, 0);
    }

    // Helper method to print the tree sideways
    public static void printTree(TreeNode node, int level) {
        if (node == null) return;
        printTree(node.right, level + 1);
        System.out.println(" ".repeat(level * 4) + node.val);
        printTree(node.left, level + 1);
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
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
    }
}

