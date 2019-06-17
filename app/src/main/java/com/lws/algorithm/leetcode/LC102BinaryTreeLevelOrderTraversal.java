package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LC102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        int[] array = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array, 1);
        List<List<Integer>> lists = new LC102BinaryTreeLevelOrderTraversal().levelOrder(root);
        System.out.println("[");
        for (List<Integer> list : lists) {
            System.out.print("  [");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("],");
        }
        System.out.println("]");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    levelList.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            result.add(levelList);
        }
        return result;
    }

    /**
     * 递归
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        levelOrderRecursive(queue, result);
        return result;
    }

    public void levelOrderRecursive(Queue<TreeNode> queue, List<List<Integer>> result) {
        if (queue.isEmpty()) {
            return;
        }
        int levelSize = queue.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        result.add(list);
        levelOrderRecursive(queue, result);
    }
}
