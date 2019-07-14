package com.lws.algorithm.utils;

/**
 * 链表工具类
 */
public class ListUtil {

    /**
     * 生成链表，返回头结点
     */
    public static ListNode createList(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode[] nodes = new ListNode[vals.length];
        for (int i = vals.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(vals[i]);
            nodes[i] = node;
            if (i == vals.length - 1) {
                node.next = null;
            } else {
                node.next = nodes[i + 1];
            }
        }
        return nodes[0];
    }

    /**
     * 生成链表，返回链表节点的数组
     */
    public static ListNode[] createListArray(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode[] nodes = new ListNode[vals.length];
        for (int i = vals.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(vals[i]);
            nodes[i] = node;
            if (i == vals.length - 1) {
                node.next = null;
            } else {
                node.next = nodes[i + 1];
            }
        }
        return nodes;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        System.out.print("List: ");
        while (cur != null) {
            System.out.print(cur.val + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

}
