package com.gfh.leet.p100.p032;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                num.push(start < 0 ? i : start);
                stack.push(c);
                start = -1;
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    start = num.pop();
                    res = Math.max(res, i - start + 1);
                } else {
                    start = -1;
                    stack.clear();
                    num.clear();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution();
    }
}
