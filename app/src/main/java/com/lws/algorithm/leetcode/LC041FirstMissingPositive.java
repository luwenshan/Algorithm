package com.lws.algorithm.leetcode;

public class LC041FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 5, 6, 2, 3, 4};
        int i = new LC041FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
