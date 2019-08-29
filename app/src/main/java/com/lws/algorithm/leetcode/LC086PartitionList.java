package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC086PartitionList {
    public static void main(String[] args) {
        int[] vals = {1, 4, 3, 2, 5, 2};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC086PartitionList().partition(head, -10);
        ListUtil.printList(head);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode cur = head, p1 = h1, p2 = h2;
        while (cur != null) {
            if (cur.val < x) {
                p1.next = cur;
                p1 = cur;
            } else {
                p2.next = cur;
                p2 = cur;
            }
            cur = cur.next;
        }
        p1.next = h2.next;
        p2.next = null;
        return h1.next;
    }
}
