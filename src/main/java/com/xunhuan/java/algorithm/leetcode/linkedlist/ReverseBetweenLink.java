package com.xunhuan.java.algorithm.leetcode.linkedlist;

/**
 * @author tianh
 * @description:
 * @date 2022/7/28 00:35
 */
public class ReverseBetweenLink {

    /**
     * 双指针做法
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here

        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int j = 0; j < n - m + 1; j++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        // 断开
        pre.next = null;
        rightNode.next = null; // 影响leftNode(leftNode在此处被截取成需翻转的区间链表)
        // 部分翻转链表
        reverseList(leftNode); // 翻转过程会影响rightNode

        // 拼接 - 翻转之后left和right相当于互换指针,所以pre的next拼接right,left的next拼接cur
        pre.next = rightNode;
        leftNode.next = cur;

        return dummyNode.next;
    }

    public void reverseList(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }


        ListNode cur = pre.next;
        ListNode cur_next;

        for (int i = 0; i < n - m; i++) {
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ReverseBetweenLink link = new ReverseBetweenLink();
        link.reverseBetween2(listNode, 2, 4);
        System.out.println(link);
    }
}