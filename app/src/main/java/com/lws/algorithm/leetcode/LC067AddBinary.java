package com.lws.algorithm.leetcode;

public class LC067AddBinary {
    public static void main(String[] args) {
        String res = new LC067AddBinary().addBinary("101", "11");
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int aByte = 0;
        int bByte = 0;
        StringBuilder sb = new StringBuilder();
        int res = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            aByte = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            bByte = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;
            res = aByte ^ bByte ^ carry;
            carry = (aByte + bByte + carry) >= 2 ? 1 : 0;
            i--;
            j--;
            sb.append(res);
        }
        return sb.reverse().toString();
    }
}
