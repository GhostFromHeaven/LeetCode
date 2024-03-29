package com.gfh.leet.p100.p006;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }

        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : 2 * numRows - 2 - index;
            sb[index].append(s.charAt(i));
        }

        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i].toString());
        }

        return sb[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING", 3));
        System.out.println(new Solution().convert("LEETCODEISHIRING", 4));
    }
}
