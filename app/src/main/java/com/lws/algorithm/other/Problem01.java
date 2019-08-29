package com.lws.algorithm.other;

/**
 * 题目描述：求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Problem01 {
    public static void main(String[] args) {
        int result = new Problem01().f(5);
        System.out.println(result);
    }

    // 通过递归变形而来，这个 && 逻辑判断符的作用就是：
    // 如果 n != 0 成立的话，那么逻辑判断符后面的判断语句 (f(n-1) + n ) != 0 也会执行，
    // 如果 n != 0 不成立的话，那么后面的判断语句 ((f(n-1) + n)) != 0 就不会执行，
    // 通过这种方法，就可以达到我们递归结束条件判断的目的了。
    public int f(int n) {
        int sum = n;
        boolean t = (n != 0) && (sum += f(n - 1)) != 0;
        return sum;
    }

    // 递归，不符合要求
    public int recursive(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + recursive(n - 1);
        }
    }
}
