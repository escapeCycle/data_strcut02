package com.xunhuan.java.structure.linkedlist;

/**
 * @author tianhuan
 * @date 2018-12-10 16:56
 **/
public class Solution {

    /**
     * 判断是否是循环链表
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 返回循环链表的起始点(或head)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return null;
        }
        slow = head;
        if (slow == fast) {
            return slow;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 获取交叉点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    /**
     * 1->2->3->4->5  n=2   1->2->3->5
     * 从链表后端第n个位置移除元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode resultNode = head;
        ListNode sNode = resultNode;
        ListNode fNode = resultNode;
        int sCount = 1;
        int fCount = 1;
        while(fNode.next != null){
            if(fCount > n){
                sNode = sNode.next;
                sCount++;
                fNode = fNode.next;
                fCount++;
            }else{
                fNode = fNode.next;
                fCount++;
            }
        }
        if((fCount-sCount) != n){
            return resultNode.next;
        }else{
            sNode.next = sNode.next.next;
            return resultNode;
        }

    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head,
                prev = null,
                reversed = null;

        while (node != null) {
            final ListNode next = node.next;

            if (node.next == null) {
                reversed = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }

        return reversed;
    }

    public static void main(String[] args) {
//        Solution s = new Solution();
//        ListNode node = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;

//        System.out.println(s.hasCycle(node));

//        System.out.println(s.detectCycle(node).val);

        Solution s = new Solution();
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
        ListNode result = s.getIntersectionNode(a1, b1);
        System.out.println(result.val);


        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = s.removeNthFromEnd(node, 2);
        System.out.println(listNode.val);


        ListNode nodeList = s.reverseList(node);
        System.out.println(nodeList.val);
    }
}
