package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC143ReorderList {
    public static void main(String[] args) {
        int[] vals = {1};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        new LC143ReorderList().reorderList(head);
        ListUtil.printList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (p != null) {
            ListNode nxt = p.next;
            p.next = pre;
            pre = p;
            p = nxt;
        }
        ListNode p1 = head, p2 = pre;
        while (p1 != null && p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }
    }
}
