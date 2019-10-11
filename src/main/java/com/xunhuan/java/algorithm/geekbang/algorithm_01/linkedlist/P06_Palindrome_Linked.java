package com.xunhuan.java.algorithm.geekbang.algorithm_01.linkedlist;

/**
 * 单链表存储数据，如何判断其是否为回文数  例 12321  2332
 * <p>
 * 快慢指针，快指针不能再走的时候，慢指针在中间位置
 */
public class P06_Palindrome_Linked {


    public static boolean isPalindrome(ListNode node) {
        if (node == null || node.next == null) return true;

        ListNode slow = node, fast = node;
        ListNode prev = null;


        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        /**
         * 区分奇偶
         * fast != null 是奇数，刚好快指针走完，慢指针在中间位，需要移动一位与之前的翻转链表比对
         * fast == null 是偶数，快指针未走完，慢指针在下中间位
         */
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        boolean palindrome = P06_Palindrome_Linked.isPalindrome(head);

        System.out.println(palindrome);
    }
}
