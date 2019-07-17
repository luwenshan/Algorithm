package com.lws.algorithm.standard;

import java.util.Arrays;

/**
 * 排序算法
 */
public class Sort {

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 1, 3, 6};
        new Sort().selectionSort(a, 6);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 提前退出的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     */
    public void insertionSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > tmp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = tmp;
        }
    }

    /**
     * 选择排序
     */
    public void selectionSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = tmp;
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }

    }
}
