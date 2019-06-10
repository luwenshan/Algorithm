package com.lws.algorithm.leetcode;

public class LC028ImplementStrStr {
    public static void main(String[] args) {
        int index = new LC028ImplementStrStr().strStr3("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println(index);
    }

    /**
     * 暴力解法，时间复杂度O(m * n)
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 暴力解法，时间复杂度O(m * n)
     */
    public int strStr2(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * KMP算法，时间复杂度O(m + n)
     * https://blog.csdn.net/v_july_v/article/details/7041827
     */
    public int strStr3(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        //generate next array, need O(n) time
        int i = -1, j = 0, m = haystack.length(), n = needle.length();
        int[] next = new int[n];
        next[0] = -1;
        while (j < n - 1) {
            if (i == -1 || needle.charAt(i) == needle.charAt(j))
                next[++j] = ++i;
            else
                i = next[i];
        }
        //check through the haystack using next, need O(m) time
        i = 0;
        j = 0;
        while (i < m && j < n) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if (j == n)
            return i - j;
        return -1;
    }
}
