package com.lws.algorithm.leetcode;

import java.util.Arrays;

public class LC027RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 1, 2, 3};
        int result = new LC027RemoveElement().removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println("result:" + result);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
