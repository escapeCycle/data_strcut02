package com.xunhuan.java.algorithm.leetcode.linkedlist;

/**
 * @author tianh
 * @description:
 * @date 2024/4/7 22:20
 */
public class LeetCode_019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode tmp = head;
        int sz = 1;
        while(tmp.next != null){
            sz++;
            tmp = tmp.next;
        }
        int frontNum = sz - n + 1;
        if(frontNum == 1){
            return head.next;
        }
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        int step = 1;
        while(head != null){
            if(step == (frontNum - 1) && head.next != null){
                head.next = head.next.next;
                break;
            }else{
                head = head.next;
                step++;
            }
        }
        return dumpNode.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode first = head;
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode second = tmp;

        for(int i = 0; i < n; i++){
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return tmp.next;
    }

    public static void main(String[] args) {
        LeetCode_019 leetCode_019 = new LeetCode_019();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;

        leetCode_019.removeNthFromEnd(listNode, 1);
    }
}
