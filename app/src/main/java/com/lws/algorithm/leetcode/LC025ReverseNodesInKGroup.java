package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC025ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.createList(vals);
        ListUtil.printList(head);
        head = new LC025ReverseNodesInKGroup().reverseKGroup(head, 3);
        ListUtil.printList(head);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h, nxt = h;
        while (nxt != null) {
            for (int i = 0; i < k; i++) {
                if (nxt != null) {
                    nxt = nxt.next;
                } else {
                    break;
                }
            }
            if (nxt == null) {
                break;
            }
            ListNode last = nxt;
            nxt = nxt.next;
            last.next = null;
            ListNode first = reverseList(pre.next);
            last = pre.next;
            last.next = nxt;
            pre.next = first;
            pre = last;
            nxt = pre;
        }
        return h.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
