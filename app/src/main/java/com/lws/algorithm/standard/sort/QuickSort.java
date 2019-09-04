package com.lws.algorithm.standard.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 1, 3, 6};
        new QuickSort().quickSort(a, 6);
        System.out.println(Arrays.toString(a));
        int kth = new QuickSort().kthSmallest(a, 1);
        System.out.println(kth);
    }

    public void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i != j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                i++;
            }
        }
        a[r] = a[i];
        a[i] = pivot;
        System.out.println("i = " + i);
        return i;
    }

    /**
     * O(n) 时间复杂度内求无序数组中的第 K 大元素。比如，4， 2， 5， 12， 3 这样一组数据，第 3 大元素就是4。
     */
    public int kthSmallest(int[] a, int k) {
        if (a == null || a.length == 0 || k > a.length) {
            return -1;
        }
        int p = partition(a, 0, a.length - 1);
        while (p + 1 != k) {
            if (p + 1 < k) {
                p = partition(a, p + 1, a.length - 1);
            } else {
                p = partition(a, 0, p - 1);
            }
        }
        return a[p];
    }
}
