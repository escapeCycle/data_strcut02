package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 找到单链表的中间节点（偶数个的话，取后一个）
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * @author tianhuan
 * @date 2019-03-12 13:58
 **/
public class LeetCode_876 {

    /**
     * 先遍历一遍记住长度
     * 遍历第二遍记住每一个index
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        int size = 1;
        ListNode current = head;
        while (current.next != null){
            current = current.next;
            size++;
        }
        int count = 0;
        int mid = size/2;
        /*
            重置
         */
        current = head;
        while (current.next != null){
            if(count == mid){
                return current;
            }
            current = current.next;
            count++;
        }
        return current;
    }

    /**
     * 用数组来记住index
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {

        ListNode[] nodes = new ListNode[200];
        int i = 1;
        nodes[0] = head;
        while (head.next != null){
            nodes[i++] = head.next;
            head = head.next;
        }
        return nodes[i/2];
    }

    /**
     * 快慢指针做法
     * @param head
     * @return
     */
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = new LeetCode_876().middleNode3(head);
        System.out.println(node.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
