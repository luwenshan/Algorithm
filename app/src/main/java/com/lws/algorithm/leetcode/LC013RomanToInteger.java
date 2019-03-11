package com.lws.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC013RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 <= s.length() && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i++;
            } else {
                res += map.get(s.substring(i, i + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC013RomanToInteger().romanToInt("MCCLVI"));
    }
}
