package com.lws.algorithm.leetcode;

public class LC070ClimbingStairs {
    public static void main(String[] args) {
        int res = new LC070ClimbingStairs().climbStairs(3);
        System.out.println(res);
    }

    /**
     * Fibonacci 数列问题
     * F[0] = 0, F[1] = 1, F[n] = F[n-1] + F[n-2]
     */
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int a = 1, b = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            b = a;
            a = res;
        }
        return res;
    }
}
