package com.lws.algorithm.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * （二叉）树相关工具类
 */
public class TreeUtil {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 3};
        TreeNode node = createBTreeByLevelOrder(array, 1);
        System.out.println(node.val);
    }

    /**
     * 基于层序遍历序列构造二叉树, <= 0 为空
     * 编号：层次从上到下，每层从左到右。对于编号为i的节点，若存在左孩子，则左孩子编号为2i，若存在右孩子，则编号为2i+1
     * @param i 当前编号，从1开始
     */
    public static TreeNode createBTreeByLevelOrder(int[] array, int i) {
        if (i > array.length || array[i - 1] <= 0) {
            return null;
        }
        TreeNode node = new TreeNode(array[i - 1]);
        node.left = createBTreeByLevelOrder(array, 2 * i);
        node.right = createBTreeByLevelOrder(array, 2 * i + 1);
        return node;
    }

    public static TreeNode createBTreeByLevelOrder(Integer[] array) {
        return createBTreeByLevelOrder(array, 1);
    }

    public static TreeNode createBTreeByLevelOrder(Integer[] array, int i) {
        if (i > array.length || array[i - 1] == null) {
            return null;
        }
        TreeNode node = new TreeNode(array[i - 1]);
        node.left = createBTreeByLevelOrder(array, 2 * i);
        node.right = createBTreeByLevelOrder(array, 2 * i + 1);
        return node;
    }

    public static void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }
}
