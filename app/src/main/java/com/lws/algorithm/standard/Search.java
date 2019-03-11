package com.lws.algorithm.standard;

public class Search {
    // 二分查找
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low, high, mid;
        low = fromIndex;
        high = toIndex - 1;
        while (low <= high) {
            // 二分
            mid = (low + high) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 插值查找
    public static int interpolationSearch(int[] a, int fromIndex, int toIndex, int key) {
        int low, high, mid;
        low = fromIndex;
        high = toIndex - 1;
        while (low <= high) {
            // 插值
            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Fibonacci查找
    public static int fibonacciSearch(int[] a, int key) {
        int[] F = new int[]{0, 1, 1, 2, 3, 8, 13, 21, 34};
        int n = a.length - 1;
        int low, high, mid, i, k;
        low = 0;
        high = n;
        k = 0;
        while (n > F[k] - 1)
            k++;
        int[] tmp = new int[F[k] - 1];
        System.arraycopy(a, 0, tmp, 0, a.length);
        for (i = n; i < F[k] - 1; i++) {
            tmp[i] = a[n];
        }
        while (low <= high) {
            mid = low + F[k - 1] - 1;
            if (key > tmp[mid]) {
                high = mid - 1;
                k = k - 1;
            } else if (key > tmp[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= n) {
                    return mid;
                } else {
                    return n;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int index = fibonacciSearch(a, 59);
        System.out.println(index);
    }
}
