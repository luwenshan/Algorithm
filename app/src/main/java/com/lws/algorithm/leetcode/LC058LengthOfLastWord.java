package com.lws.algorithm.leetcode;

public class LC058LengthOfLastWord {
    public static void main(String[] args) {
        int res = new LC058LengthOfLastWord().lengthOfLastWord2("Hello World   ");
        System.out.println(res);
    }

    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr.length == 0 ? 0 : arr[arr.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        int i = s.length() - 1, res = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            res++;
        }
        return res;
    }

}
