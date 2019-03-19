package com.xunhuan.java.structure.linkedlist;

/**
 *
 * 有关单链表的题目
 * @author tianhuan
 * @date 2019-03-06 10:34
 **/
public class LinkedSubject {

    /**
     * 判断是否是循环链表
     * @param node
     * @return
     */
    public boolean hasCycle(ListNode node){
        if(node == null){
            return false;
        }
        if(node.next == null){
            return false;
        }

        ListNode slow = node,fast = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 返回循环链表的起始点
     * @return
     */
    public ListNode detectCycle(ListNode node){
        if(node == null){
            return null;
        }
        if(node.next == null){
            return null;
        }

        ListNode slow = node,fast = node;
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
            }
        }

        if(!isCycle){
            return null;
        }

        if(slow == fast){
            return slow;
        }
        slow = node;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     * @return
     */
    public ListNode reverseList(ListNode node){
        if(node == null){
            return null;
        }
        if(node .next == null){
            return node;
        }

        ListNode pre = null,
                 reverse = null,
                 current = node;

        while (current != null){
            final ListNode next = current.next;
            while (current.next == null){
                reverse = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        return reverse;
    }
}
