package com.lws.algorithm.standard.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 1, 3, 6};
        new MergeSort().mergeSort(a, 6);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }
        mergeSortInternally(a, 0, n - 1);
    }

    private void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        merge(a, p, q, r);
    }

    // 将a[p,q]和a[q+1,r]合并
    private void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }
}
