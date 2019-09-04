package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;
import com.lws.algorithm.utils.TreeNode;
import com.lws.algorithm.utils.TreeUtil;

public class LC109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        TreeNode root = new LC109ConvertSortedListToBinarySearchTree().sortedListToBST2(head);
        TreeUtil.printTreeLevelOrder(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head.next.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    ListNode head;

    /**
     * 模拟树的中序遍历，时间复杂度为O(n)
     */
    public TreeNode sortedListToBST2(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        this.head = head;
        return toBst(0, size - 1);
    }

    private TreeNode toBst(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = toBst(l, mid - 1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        this.head = head.next;
        node.right = toBst(mid + 1, r);
        return node;
    }
}
