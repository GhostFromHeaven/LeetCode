package com.gfh.leet.p100.p041;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solution().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
