package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class LC876MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode head = ListUtil.createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middleNode = new LC876MiddleOfTheLinkedList().middleNode(head);
        System.out.println(middleNode.val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
