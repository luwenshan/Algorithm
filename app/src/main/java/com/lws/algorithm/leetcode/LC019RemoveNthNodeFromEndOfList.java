package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 */
public class LC019RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC019RemoveNthNodeFromEndOfList().removeNthFromEnd2(head, 2);
        ListUtil.printList(head);
    }

    // 一次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return null;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p1 = h, p2 = h;
        for (int i = 0; i <= n; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return h.next;
    }

    // 两次遍历
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        length = length - n;
        cur = h;
        for (int i = 0; i < length; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return h.next;
    }
}
