package com.gfh.leet.p100.p005;

public class Solution {
    String res = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        res = "";

        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
