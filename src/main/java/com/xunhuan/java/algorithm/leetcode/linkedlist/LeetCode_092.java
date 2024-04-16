package com.xunhuan.java.algorithm.leetcode.linkedlist;

/**
 * @author tianh
 * @description: 翻转区间链表
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * @date 2024/4/8 21:44
 */
public class LeetCode_092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode pre = tmp;

        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }


        ListNode rightNode = pre;
        for(int j = 0; j < right - left + 1; j++){
            rightNode = rightNode.next;
        }

        ListNode midNode = pre.next;
        ListNode tailNode = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        // midNode 翻转完，刚好节点在最后一个位置
        reverseList(midNode);

        pre.next = rightNode;
        midNode.next = tailNode;

        return tmp.next;
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode tmp = new ListNode(-1);

        while(head != null){
            ListNode next = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = next;
        }
        return tmp.next;
    }
}
