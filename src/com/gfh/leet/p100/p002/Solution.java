package com.gfh.leet.p100.p002;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);

        int sum = 0;
        ListNode cur = header;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum % 10);
            sum /= 10;

            cur = cur.next;
        }

        if (sum > 0) {
            cur.next = new ListNode(sum);
        }

        return header.next;
    }

}