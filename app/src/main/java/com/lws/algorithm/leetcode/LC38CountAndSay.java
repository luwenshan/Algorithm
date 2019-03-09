package com.lws.algorithm.leetcode;

/**
 * 参考：
 * https://leetcode.windliang.cc/leetCode-38-Count-and-Say.html
 */
public class LC38CountAndSay {

    public static void main(String[] args) {
        String result = new LC38CountAndSay().countAndSay2(1);
        System.out.println(result);
    }

    /**
     * 递归
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        //得到上一行的字符串
        String last = countAndSay(n - 1);
        //输出当前行的字符串
        return getNextString(last);
    }

    private String getNextString(String last) {
        if (last.length() == 0) {
            return "";
        }
        //得到第 1 个字符重复的次数
        int num = getRepeatNum(last);
        // 次数 + 当前字符 + 其余的字符串的情况
        return "" + num + last.charAt(0) + getNextString(last.substring(num));
    }

    //得到字符 string[0] 的重复个数，例如 "111221" 返回 3
    private int getRepeatNum(String s) {
        int count = 1;
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 迭代
     */
    public String countAndSay2(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            String pre = res;
            char ch = pre.charAt(0);
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (ch == pre.charAt(j)) {
                    count++;
                } else {
                    res = res + count + ch;
                    count = 1;
                    ch = pre.charAt(j);
                }
            }
            res = res + count + ch;
        }
        return res;
    }

    public String countAndSay3(int n) {
        String res = "1";
        //从第一行开始，一行一行产生
        while (n > 1) {
            String temp = "";
            for (int i = 0; i < res.length(); i++) {
                int num = getRepeatNum(res.substring(i));
                temp = temp + num + "" + res.charAt(i);
                //跳过重复的字符
                i = i + num - 1;
            }
            n--;
            //更新
            res = temp;
        }
        return res;

    }
}
