package com.lws.algorithm.leetcode;

public class LC007ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        // 判断是否溢出
        if ((int) res != res) {
            return 0;
        } else {
            return (int) res;
        }
    }

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            int newRes = res * 10 + tail;
            // 判断是否溢出
            if ((newRes - tail) / 10 != res) {
                return 0;
            }
            x = x / 10;
            res = newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC007ReverseInteger().reverse2(120));
    }
}
