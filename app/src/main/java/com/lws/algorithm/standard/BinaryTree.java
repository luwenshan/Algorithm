package com.lws.algorithm.standard;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

public class BinaryTree {
    /**
     *                  1
     *                 / \
     *                2   3
     *               / \ / \
     *              4  5 6  7
     *             / \
     *            8   9
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeUtil.createBTreeByLevelOrder(array, 1);
        System.out.println("前序遍历：");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrder(root);
        System.out.println();
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

}
