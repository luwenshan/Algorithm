package com.lws.algorithm.leetcode;

public class LC053MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = new LC053MaximumSubarray().maxSubArray(nums);
        System.out.println(max);
    }

    /**
     * O(n) solution
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // choose a larger one between current number or (previous sum + current number).
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}
