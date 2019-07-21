package com.lws.algorithm.standard.sort;

import java.util.Arrays;

/**
 * 计数排序
 * <p>
 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 * 而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        new CountingSort().countingSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    // n 为数组大小，假设a中存储的都是非负整数
    public void countingSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }

        // 查找数据范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 计算每个数据出现次数
        int[] c = new int[max + 1];
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        // 累加
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }

        int[] r = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int value = a[i];
            int index = c[value] - 1;
            r[index] = value;
            c[value]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }
}
