package twosum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            Integer v = map.get(gap);
            if (v != null) {
                result[0] = map.get(gap);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    private static void test(int[] nums, int target) {
        System.out.printf("%s -> ", Arrays.toString(nums));
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        test(new int[]{2, 7, 11, 15}, 9);
        test(new int[]{2, 7, 11, 15}, 13);
        test(new int[]{2, 7, 11, 15}, 17);
        test(new int[]{2, 7, 11, 15}, 18);
        test(new int[]{2, 7, 11, 15}, 22);
        test(new int[]{2, 7, 11, 15}, 26);
    }
}
