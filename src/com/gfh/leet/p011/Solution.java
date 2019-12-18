package com.gfh.leet.p011;

public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            res = Math.max(res, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
