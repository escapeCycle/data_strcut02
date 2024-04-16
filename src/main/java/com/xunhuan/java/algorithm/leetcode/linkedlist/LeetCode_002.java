package com.xunhuan.java.algorithm.leetcode.linkedlist;

import java.util.HashMap;

/**
 * @author tianh
 * @description:
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 *  输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @date 2022/8/24 21:59
 */
public class LeetCode_002 {


    /**
     * 此方法不能通过，原因是 int有最大限制,超出限制之后数值不对
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        if (l1.next == null && l2.next == null) {
            int c = l1.val + l2.val;
            switchToNode(c, res);
            return res.next;
        }
        int l1Val = 0, l2Val = 0;
        int step1 = 1;
        while (l1 != null) {
            l1Val += l1.val * step1;
            step1 *= 10;
            l1 = l1.next;
        }
        int step2 = 1;
        while (l2 != null) {
            l2Val += l2.val * step2;
            step2 *= 10;
            l2 = l2.next;
        }
        int resInt = l1Val + l2Val;
        switchToNode(resInt, res);
        return res.next;
    }

    public void switchToNode(int c, ListNode res) {
        String cStr = String.valueOf(c);
        for (int i = cStr.length() - 1; i >= 0; i--) {
            res.next = new ListNode(cStr.charAt(i) - '0');
            res = res.next;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        LeetCode_002 leetCode_002 = new LeetCode_002();
        ListNode l1 = new ListNode(9);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode listNode = leetCode_002.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
