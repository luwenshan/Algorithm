package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

import java.util.LinkedList;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class LC112PathSum {
    public static void main(String[] args) {
        Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array);
        boolean result = new LC112PathSum().hasPathSum2(root, 22);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        stack.push(root);
        sumStack.push(sum);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int curSum = sumStack.pop();
            if (node.left == null && node.right == null && node.val == curSum) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                sumStack.push(curSum - node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                sumStack.push(curSum - node.val);
            }
        }
        return false;
    }
}
