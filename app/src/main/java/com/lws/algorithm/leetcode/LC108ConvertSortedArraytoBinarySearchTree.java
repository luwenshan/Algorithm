package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class LC108ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        TreeNode root = new LC108ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(array);
        TreeUtil.printTreeLevelOrder(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
//        int mid = left + (right - left) / 2;
        int mid = left + (right - left + 1) / 2; // avoids integer overflow
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
