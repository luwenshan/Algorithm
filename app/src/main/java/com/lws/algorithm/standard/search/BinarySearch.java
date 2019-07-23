package com.lws.algorithm.standard.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5, 6, 8, 9, 10};
        int index = new BinarySearch().bsearch4(a, a.length, 7);
        System.out.println(index);
    }

    /**
     * 有序数组中不存在重复元素
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 有序数组中存在重复元素，查找第一个等于给定值的元素
     */
    public int bsearch2(int[] a, int n, int value) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (value < a[mid]) {
                high = mid - 1;
            } else if (value > a[mid]) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 有序数组中存在重复元素，查找最后一个等于给定值的元素
     */
    public int bsearch3(int[] a, int n, int value) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value < a[mid]) {
                high = mid - 1;
            } else if (value > a[mid]) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public int bsearch4(int[] a, int n, int value) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public int bsearch5(int[] a, int n, int value) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
