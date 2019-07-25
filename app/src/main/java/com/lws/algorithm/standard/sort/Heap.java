package com.lws.algorithm.standard.sort;

import java.util.Arrays;

/**
 * 堆的定义：
 * 1.堆是一个完全二叉树
 * 2.堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值
 */
public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n; // 最大容量
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public static void main(String[] args) {
        int[] a = {0, 5, 8, 1, 4, 3, 9, 6};
        heapSort(a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    // n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
    public static void heapSort(int[] a, int n) {
        // 建堆
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            // 删除堆顶元素，将其移到最后
            swap(a, 1, k);
            --k;
            // 堆化
            heapify(a, k, 1);
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    // 自上向下堆化
    private static void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i <= count && a[2 * i] > a[i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= count && a[2 * i + 1] > a[maxPos]) {
                maxPos = 2 * i + 1;
            }
            if (i == maxPos) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 插入一个元素
    public void insert(int data) {
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下向上堆化，i/2为父节点
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    // 删除堆顶元素
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }
}
