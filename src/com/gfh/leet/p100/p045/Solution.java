package com.gfh.leet.p100.p045;

public class Solution {
    public int jump(int[] nums) {
        int nextStep = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == nextStep) {
                nextStep = maxPosition;
                steps++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
