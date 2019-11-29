package addtwonumbers;

import java.util.Arrays;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        add(result, l1);
        add(result, l2);
        return result;
    }

    private void add(ListNode result, ListNode ln) {
        ListNode resultTail = result;
        int add = 0;
        int sum = 0;
        while (ln != null) {
            sum = resultTail.val + ln.val + add;
            add = sum / 10;
            sum = sum % 10;
            resultTail.val = sum;

            ln = ln.next;
            if ((ln != null || add > 0) && resultTail.next == null) {
                resultTail.next = new ListNode(add);
                add = 0;
            }

            resultTail = resultTail.next;
        }

        if (add != 0) {
            while (resultTail != null) {
                resultTail.val += add;
                add = resultTail.val / 10;
                resultTail.val %= 10;

                if (add > 0 && resultTail.next == null) {
                    resultTail.next = new ListNode(add);
                    add = 0;
                }

                resultTail = resultTail.next;
            }
        }

    }

    private static ListNode createNode(int[] nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode tail = node;
        for (int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return node;
    }

    private static void showNode(ListNode node) {
        while (node != null) {
            System.out.printf("%d", node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    private static void test(int[] nums1, int[] nums2) {
        ListNode n1 = createNode(nums1);
        showNode(n1);
        ListNode n2 = createNode(nums2);
        showNode(n2);
        ListNode result = new Solution().addTwoNumbers(n1, n2);
        showNode(result);
    }

    public static void main(String[] args) {
        test(new int[]{7, 8, 9}, new int[]{5, 6});
        test(new int[]{9, 9}, new int[]{9});
    }
}
