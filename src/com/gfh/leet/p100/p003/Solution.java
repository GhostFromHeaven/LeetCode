package com.gfh.leet.p100.p003;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastKeyIndex = new HashMap<Character, Integer>();
        int maxLength = 0;
        int stringLength = s.length();
        int start = 0;
        for (int i = 0; i < stringLength; i++) {
            Character c = s.charAt(i);
            int lastIndex = lastKeyIndex.getOrDefault(c, -1);
            if (lastIndex >= start) {
                start = lastIndex + 1;
            }

            int newLength = i - start + 1;
            if (newLength > maxLength) {
                maxLength = newLength;
            }

            lastKeyIndex.put(c, i);
        }

        return maxLength;
    }
}