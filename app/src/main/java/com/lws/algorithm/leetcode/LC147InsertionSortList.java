package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC147InsertionSortList {
    public static void main(String[] args) {
        int[] vals = {4, 1};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC147InsertionSortList().insertionSortList(head);
        ListUtil.printList(head);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head.next;
        head.next = null;
        ListNode p = h;
        while (cur != null) {
            p = h;
            while (p.next != null && p.next.val <= cur.val) {
                p = p.next;
            }
            ListNode nxt = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = nxt;
        }
        return h.next;
    }
}
