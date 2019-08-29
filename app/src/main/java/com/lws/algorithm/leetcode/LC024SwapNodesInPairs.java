package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC024SwapNodesInPairs {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC024SwapNodesInPairs().swapPairs2(head);
        ListUtil.printList(head);
    }

    /**
     * 递归
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = swapPairs(head.next.next);
        ListNode h = head.next;
        h.next = head;
        head.next = p;
        return h;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head, pre = h, nnxt;
        while (cur != null && cur.next != null) {
            nnxt = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = nnxt;
            pre = cur;
            cur = nnxt;
        }
        return h.next;
    }
}
