package com.lws.algorithm.other;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Problem02 {
    public static void main(String[] args) {
        int result = new Problem02().add(2, 4);
        System.out.println(result);
    }

    /**
     * 如果我们把两个数进行异或，例如num1 = 101, num2 = 001，做异或运算：tmp = num1 ^ num2，结果是 tmp = 100。
     * 那么此时得到的结果 tmp 其实就是两个数（num1,num2）各个二进制位上相加，不算进位的结果。
     * 而 num1 = (num1 & num2) << 1 的结果就是两个数相加时那些需要进位的二进制位。
     * 例如 （101 & 001）<< 1 = 010，那么两个数第一位相加需要进位，我们需要把进的那一位最后加到第二位上去。
     * 就是 a + b = a ^ b + (a & b) << 1。
     * 代码中，如果 num1 == 0 的话，代表没有进位了，此时就可以退出循环了。
     */
    public int add(int num1, int num2) {
        int tmp = 0;
        while (num1 != 0) {
            tmp = num1 ^ num2;
            num1 = (num1 & num2) << 1;
            num2 = tmp;
        }
        return num2;
    }
}
