package com.lws.algorithm.leetcode;

import com.lws.algorithm.utils.ListNode;
import com.lws.algorithm.utils.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC023MergeKSortedLists {
    public static void main(String[] args) {
        ListNode node1 = ListUtil.createList(new int[]{-2, -1, -1});
        ListNode node2 = ListUtil.createList(new int[]{1, 2, 2});
        ListNode node3 = ListUtil.createList(new int[]{2, 6});
        ListNode head = new LC023MergeKSortedLists().mergeKLists4(new ListNode[]{node1, node2, node3});
        ListUtil.printList(head);
    }

    /**
     * 分治法
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left >= right) return lists[right];
        int mid = left + (right - left) / 2;
        ListNode node1 = mergeList(lists, left, mid);
        ListNode node2 = mergeList(lists, mid + 1, right);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                tmp.next = node1;
                node1 = node1.next;
            } else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;
        }
        if (node1 != null) {
            tmp.next = node1;
        }
        if (node2 != null) {
            tmp.next = node2;
        }
        return head.next;
    }

    /**
     * 优先级队列法
     * 时间复杂度 O(N*logk),空间复杂度O(N), k 为lists数组大小, N 为节点总数
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tmp.next = node;
            tmp = node;
        }
        tmp.next = null;
        return head.next;
    }

    /**
     * 逐个比较法
     * 循环遍历lists，每次取出最小的节点，直到遍历所有节点
     * 时间复杂度 O(k*N),空间复杂度O(1), k 为lists数组大小
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int minIndex = 0;
        boolean finished = true;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    finished = false;
                    if (lists[i].val < minValue) {
                        minValue = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            if (finished) {
                break;
            }
            cur.next = lists[minIndex];
            cur = cur.next;
            lists[minIndex] = lists[minIndex].next;
            finished = true;
        }
        return head.next;
    }

    /**
     * 暴力解法
     * 将所有节点放入数组中，对数组排序，将排序后的节点连接成链表
     * 时间复杂度 O(N*logN),空间复杂度 O(N),N为节点总数
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode tmp;
        for (ListNode node : lists) {
            tmp = node;
            while (tmp != null) {
                nodeList.add(tmp);
                tmp = tmp.next;
            }
        }
        Collections.sort(nodeList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        nodeList.get(nodeList.size() - 1).next = null;
        return nodeList.get(0);
    }
}
