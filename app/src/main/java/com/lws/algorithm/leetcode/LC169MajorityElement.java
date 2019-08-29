package com.lws.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC169MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int i = new LC169MajorityElement().majorityElement2(nums);
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        int ans = nums[0];
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            if (ans == num) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}
