package longestsubstring;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/


import com.sun.deploy.util.ArrayUtil;

import java.util.HashMap;

public class Solution {
    // 窗口滑动
    public int lengthOfLongestSubstring(String s) {
        // 存储字符最后一个index
        HashMap<Character, Integer> lastKeyIndex = new HashMap<Character, Integer>();
        int maxLength = 0;
        int stringLength = s.length();
        int start = 0;
        for (int i = 0; i < stringLength; i++) {
            Character c = s.charAt(i);
            // 如果出现过 start 后移
            int lastIndex = lastKeyIndex.getOrDefault(c, -1);
            if (lastIndex >= start) {
                start = lastIndex + 1;
            }

            // 计算新对长度
            int newLength = i - start + 1;
            if (newLength > maxLength) {
                maxLength = newLength;
            }

            // 更新字符自后出现对index
            lastKeyIndex.put(c, i);
        }

        return maxLength;
    }

    private static void test(String s) {
        int length = new Solution().lengthOfLongestSubstring(s);
        System.out.printf("%s -> %d\n", s, length);
    }

    public static void main(String[] args) {
        test("abcabcbb");
        test("bbbbb");
        test("pwwkew");
        test("dvdf");
        test(" ");
    }
}
