package com.xunhuan.java.structure.linkedlist;

/**
 * @author tianhuan
 * @date 2018-12-10 16:56
 **/
public class Solution2 {


    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode node = head,before = null,reverseNode = null;

        while(node != null){
            ListNode next = node.next;
            if(node.next == null){
                reverseNode = node;
            }
            node.next = before;
            before = node;
            node = next;
        }
        return reverseNode;
    }



    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(-4);
        ListNode b3 = new ListNode(5);
        ListNode b4 = new ListNode(10);
        ListNode b5 = new ListNode(9);
        ListNode b6 = new ListNode(1);

        a1.next = a2;
        a2.next = b4;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;


        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode nodeList = s.reverseList(node);
        System.out.println(nodeList.val);
    }
}
