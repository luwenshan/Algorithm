package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
public class LC110BalancedBinaryTree {
    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
//        Integer[] array = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array);
        boolean balanced = new LC110BalancedBinaryTree().isBalanced2(root);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 改进算法
     */
    public boolean isBalanced2(TreeNode root) {
        return getDepth2(root) != -1;
    }

    /**
     * return -1 代表不平衡
     */
    private int getDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth2(root.left);
        int right = getDepth2(root.right);
        if (left != -1 && right != -1 && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
