package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC061RotateList {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC061RotateList().rotateRight(head, 5);
        ListUtil.printList(head);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        int length = 1;
        ListNode cur = head, tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        for (int i = 0; i < length - k - 1; i++) {
            cur = cur.next;
        }
        ListNode h = cur.next;
        cur.next = null;
        tail.next = head;
        return h;
    }
}
