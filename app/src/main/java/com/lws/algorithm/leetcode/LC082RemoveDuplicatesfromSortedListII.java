package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class LC082RemoveDuplicatesfromSortedListII {
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
        ListNode head = new LC082RemoveDuplicatesfromSortedListII().deleteDuplicates(nodes[0]);
        printList(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmpHead = new ListNode(head.val - 1);
        tmpHead.next = head;
        ListNode pre = tmpHead, cur = pre.next, next;
        while (cur != null && cur.next != null) {
            next = cur.next;
            if (cur.val == next.val) {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = pre.next;
        }
        return tmpHead.next;
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
