package com.lws.algorithm.standard;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 2, 1, 3, 6};
        new MergeSort().mergeSort(a, 6);
        System.out.println(Arrays.toString(a));
    }
}
