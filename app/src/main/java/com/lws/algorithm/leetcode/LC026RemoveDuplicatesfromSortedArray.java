package com.lws.algorithm.leetcode;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class LC026RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 3, 4, 5, 5};
        int result = new LC026RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
        System.out.println("result:" + result);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
