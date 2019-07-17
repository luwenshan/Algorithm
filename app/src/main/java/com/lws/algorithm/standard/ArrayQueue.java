package com.lws.algorithm.standard;

/**
 * 用数组实现的队列
 * <p>
 * 数据结构与算法之美
 * https://time.geekbang.org/column/article/41330
 */
public class ArrayQueue {
    private String[] items;
    // 数组大小
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            // 队列已满
            if (head == 0) {
                return false;
            }
            // 数据迁移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[head];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
        // 队列为空
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head++;
        return item;
    }
}
