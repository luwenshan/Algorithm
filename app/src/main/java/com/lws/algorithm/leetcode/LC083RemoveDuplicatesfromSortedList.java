package com.lws.algorithm.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class LC083RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        int[] vals = {1, 1, 1, 2, 3, 4, 5, 5, 5, 6, 7};
        ListNode[] nodes = new ListNode[vals.length];
        for (int i = vals.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(vals[i]);
            nodes[i] = node;
            if (i == vals.length - 1) {
                node.next = null;
            } else {
                node.next = nodes[i + 1];
            }
        }

        printList(nodes[0]);
        ListNode head = new LC083RemoveDuplicatesfromSortedList().deleteDuplicates(nodes[0]);
        printList(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, cur = pre.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = pre.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
        System.out.println();
    }
}
