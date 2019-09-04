package com.lws.algorithm.leetcode;

public class LC138CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            Node node = new Node();
            node.val = cur.val;
            cur.next = node;
            node.next = nxt;
            cur = nxt;
        }
        cur = head;
        while (cur != null && cur.next != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        Node copyHead = head.next;
        cur = head;
        while (cur != null && cur.next != null) {
            nxt = cur.next;
            cur.next = nxt.next;
            if (cur.next != null) {
                nxt.next = cur.next.next;
            } else {
                nxt.next = null;
            }
            cur = cur.next;
        }
        return copyHead;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}


