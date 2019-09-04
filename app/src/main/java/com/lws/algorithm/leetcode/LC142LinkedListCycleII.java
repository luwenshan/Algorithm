package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

public class LC142LinkedListCycleII {
    public static void main(String[] args) {
        int[] vals = {3, 2, 0, -4};
        ListNode[] listArray = ListUtil.createListArray(vals);
        listArray[3].next = listArray[1];
        ListNode node = new LC142LinkedListCycleII().detectCycle(listArray[0]);
        System.out.println(node.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next, slow = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
