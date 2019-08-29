package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC092ReverseLinkedListII {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC092ReverseLinkedListII().reverseBetween(head, 1, 1);
        ListUtil.printList(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h, cur = h, p1 = h, p2 = h;
        int index = 0;
        while (cur != null && index <= n) {
            if (index == m - 1) {
                p1 = cur;
                pre = cur;
                cur = cur.next;
            } else if (index == m) {
                p2 = cur;
                pre = cur;
                cur = cur.next;
            } else if (index > m && index <= n) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            } else {
                pre = cur;
                cur = cur.next;
            }
            index++;
        }
        p1.next = pre;
        p2.next = cur;
        return h.next;
    }
}
