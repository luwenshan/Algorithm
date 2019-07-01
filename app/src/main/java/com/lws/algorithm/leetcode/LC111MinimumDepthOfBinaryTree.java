package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class LC111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
//        Integer[] array = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array);
        int minDepth = new LC111MinimumDepthOfBinaryTree().minDepth2(root);
        System.out.println(minDepth);
    }

    /**
     * 注意，一个节点的最小高度不一定是两个子树的最小高度中较小的
     * 当一个子树为空时，该节点的最小高度等于另一个子树的最小高度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 当一个子树为空时，该节点的最小高度等于另一个子树的最小高度
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    /**
     * BFS 迭代算法，层序遍历，记录遍历的层数，一旦我们遍历到第一个叶结点，就将当前层数返回，即为二叉树的最小深度
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
