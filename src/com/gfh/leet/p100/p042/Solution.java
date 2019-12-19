package com.gfh.leet.p100.p042;

public class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                leftMax = Math.max(leftMax, height[start]);
                res += leftMax - height[start];
                start++;
            } else {
                rightMax = Math.max(rightMax, height[end]);
                res += rightMax - height[end];
                end--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
