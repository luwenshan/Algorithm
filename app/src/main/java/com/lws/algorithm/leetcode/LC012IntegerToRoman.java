package com.lws.algorithm.leetcode;

public class LC012IntegerToRoman {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[num / 100 % 10] + X[num / 10 % 10] + I[num % 10];
    }

    public static void main(String[] args) {
        System.out.println(new LC012IntegerToRoman().intToRoman(1256));
    }
}
