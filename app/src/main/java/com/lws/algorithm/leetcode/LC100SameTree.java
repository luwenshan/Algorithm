package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;

/**
 * 100. Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class LC100SameTree {
    public static void main(String[] args) {
        TreeNode p0 = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(1);
        p0.left = p1;
        p0.right = p2;

        TreeNode q0 = new TreeNode(1);
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        q0.left = q1;
        q0.right = q2;

        boolean result = new LC100SameTree().isSameTree(p0, q0);
        System.out.println(result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
