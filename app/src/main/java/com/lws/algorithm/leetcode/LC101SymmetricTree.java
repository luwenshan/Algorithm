package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class LC101SymmetricTree {
    public static void main(String[] args) {
//        int[] array = {1, 2, 2, 3, 4, 4, 3};
        int[] array = {1, 2, 2, -1, 3, -1, 3};
//        int[] array = {1, 2, 3};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array, 1);
        boolean result = new LC101SymmetricTree().isSymmetric3(root);
        System.out.println(result);
    }

    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }

    /**
     * 非递归
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val == node2.val) {
                q1.add(node1.left);
                q2.add(node2.right);
                q1.add(node1.right);
                q2.add(node2.left);
            } else {
                return false;
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root.left);
        stack2.push(root.right);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val == node2.val) {
                stack1.push(node1.left);
                stack2.push(node2.right);
                stack1.push(node1.right);
                stack2.push(node2.left);
            } else {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
