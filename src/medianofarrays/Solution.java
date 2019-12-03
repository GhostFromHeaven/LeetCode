package medianofarrays;

// https://leetcode-cn.com/problems/median-of-two-sorted-arrays/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i1 = 0;
        int i2 = 0;

        int r1 = 0;
        int r2 = 0;
        if ((n1 + n2) % 2 != 0) {
            r1 = (n1 + n2) / 2;
            r2 = r1;
        } else {
            r2 = (n1 + n2) / 2;
            r1 = r2 - 1;
        }
        int k = 0;
        int k1 = 0;
        int k2 = 0;
        int j = 0;

        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] < nums2[i2]) {
                k = nums1[i1];
                i1++;
            } else {
                k = nums2[i2];
                i2++;
            }
            if (j == r1) {
                k1 = k;
            }
            if (j == r2) {
                k2 = k;
                j++;
                break;
            }
            j++;
        }

        if (j <= r1) {
            if (i1 < n1) {
                k1 = nums1[i1 + (r1 - j)];
            } else {
                k1 = nums2[i2 + (r1 - j)];
            }
        }
        if (j <= r2) {
            if (i1 < n1) {
                k2 = nums1[i1 + (r2 - j)];
            } else {
                k2 = nums2[i2 + (r2 - j)];
            }
        }

        return (k1 + k2) / 2.0;
    }

    private static void test(int[] nums1, int[] nums2) {
        System.out.println( new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public static void main(String[] args) {
        test(new int[]{1, 3}, new int[]{2});
        test(new int[]{2}, new int[]{1, 2});
        test(new int[]{1, 2}, new int[]{3, 4});
        test(new int[]{3, 4, 5, 6}, new int[]{1, 2});
        test(new int[]{1, 2}, new int[]{3, 4, 5, 6});
    }
}
