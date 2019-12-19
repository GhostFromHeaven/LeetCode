package com.gfh.leet.p100.p043;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
            return "0";
        }

        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];
        int[] result = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            nums1[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            nums2[i] = num2.charAt(i) - '0';
        }

        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int index = result.length - (i + j) - 2;
                int res = nums1[i] * nums2[j];

                while (res > 0) {
                    result[index] += res % 10;
                    res = result[index] / 10 + res / 10;
                    result[index] %= 10;
                    index++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (sb.length() == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
    }
}
