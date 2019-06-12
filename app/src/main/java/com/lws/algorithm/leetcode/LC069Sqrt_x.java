package com.lws.algorithm.leetcode;

public class LC069Sqrt_x {
    public static void main(String[] args) {
        int res = new LC069Sqrt_x().mySqrt2(2147395599);
        System.out.println(res);
    }

    /**
     * 二分法查找(耗时长)
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            long tmp = mid * mid;
            if (tmp == x) {
                return mid;
            } else if (tmp < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 牛顿迭代法
     * https://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
     */
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        double last = 0;
        double res = 1;
        int count = 0;
        while (res != last) {
            count++;
            last = res;
            res = (res + x / res) / 2;
        }
        System.out.println(count);
        return (int) res;
    }
}
