package com.lws.algorithm.leetcode;

import java.util.Arrays;

public class LC066PlusOne {
    public static void main(String[] args) {
        int[] res = new LC066PlusOne().plusOne(new int[]{9, 9, 9, 9, 9});
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
