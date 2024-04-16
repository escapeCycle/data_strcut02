package com.xunhuan.java.algorithm.leetcode.linkedlist;

/**
 * @author tianh
 * @description: Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * @date 2021/4/2 2:56 下午
 */
public class LeetCode_024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        while(pre.next != null && pre.next.next != null){
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;
            pre = head;
            head = head.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        LeetCode_024 leetCode_024 = new LeetCode_024();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        ListNode listNode = leetCode_024.swapPairs(head);
        System.out.println(listNode.val);
    }
}
