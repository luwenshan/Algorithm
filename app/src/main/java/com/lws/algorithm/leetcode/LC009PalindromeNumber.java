package com.lws.algorithm.leetcode;

/**
 * 回文数字
 */
public class LC009PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        System.out.println(new LC009PalindromeNumber().isPalindrome(-10));
    }
}
