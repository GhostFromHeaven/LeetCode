package com.gfh.leet.p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            int sum = -nums[i];

            while (start < end) {
                if (nums[start] + nums[end] == sum) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end - 1] == nums[end]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (nums[start] + nums[end] < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
