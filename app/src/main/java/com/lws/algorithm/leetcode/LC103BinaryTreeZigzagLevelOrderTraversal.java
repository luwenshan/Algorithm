package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class LC103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        int[] array = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array, 1);
        List<List<Integer>> lists = new LC103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (reverse) {
                        levelList.add(0, node.val);
                    } else {
                        levelList.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            result.add(levelList);
            reverse = !reverse;
        }
        return result;
    }
}
