package com.lws.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC020ValidParentheses {
    public static void main(String[] args) {
        boolean result = new LC020ValidParentheses().isValid("{[]}");
        System.out.println(result);
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
