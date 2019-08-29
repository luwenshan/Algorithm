package com.lws.algorithm.other;

/**
 * 实现两个整数的相乘，不能使用乘法运算符和循环
 */
public class Problem03 {

    public static void main(String[] args) {
        int result = new Problem03().multiply(4, -5);
        System.out.println(result);
    }

    /**
     * 递归
     */
    public int multiply(int a, int b) {
        int res = mul(a, Math.abs(b));
        return b < 0 ? -res : res;
    }

    public int mul(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return b;
        }
        if (b == 1) {
            return a;
        }
        return a + mul(a, b - 1);
    }

    /**
     * 方法二，采用除法
     */
    public int multiply2(int a, int b) {
        return b != 0 ? (int) (a / (1.0 / b) + 0.99) : 0;
    }
}
