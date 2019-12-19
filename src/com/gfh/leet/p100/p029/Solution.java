package com.gfh.leet.p100.p029;

public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0) && divisor > 0) {
            sign = -1;
        }

        long res = doDivide(Math.abs((long) dividend), Math.abs((long) divisor));
        if (res > Integer.MAX_VALUE) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (sign > 0 ? res : -res);
    }

    private long doDivide(long x, long y) {
        if (x < y) {
            return 0;
        }

        long[] sums = new long[50];
        long[] muls = new long[50];
        int count = 0;
        long sum = y;
        long mul = 1;
        while (sum <= x) {
            sums[count] = sum;
            muls[count] = mul;
            count++;
            sum += sum;
            mul += mul;
        }

        mul = 0;
        int index = count - 1;
        while (x >= y) {
            for (int i = index; i >= 0; i--) {
                if (sums[i] <= x) {
                    x -= sums[i];
                    mul += muls[i];
                    index = i - 1;
                    // System.out.printf("%d*(2^%d) = %d\n", y, i, sums[i]);
                    break;
                }
            }
        }

        return mul;
    }

    private long doDivide2(long x, long y) {
        if (x < y) {
            return 0;
        }

        long sum = y;
        long mul = 1;
        while ((sum + sum) <= x) {
            sum += sum;
            mul += mul;
        }

        return mul + doDivide2(x - sum, y);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(1, 1));
        System.out.println(new Solution().divide(7, -3));
        System.out.println(new Solution().divide(10, 3));
        System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution().divide(2147483647, 3));
    }
}
