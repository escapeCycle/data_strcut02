package com.xunhuan.java.algorithm.leetcode;


/**
 * @author tianhuan
 * @date 2018-12-17 14:18
 **/
public class AddTwoNums {

    /**
     * 总会遇到存储问题,也就是无穷大总会受到存储类型限制(所以不能用一个类型接收累加值)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long num1 = 0;
        long count1 = 1;
        while (l1.next != null) {
            num1 = num1 + l1.val * count1;
            count1 *= 10;
            l1 = l1.next;
        }
        num1 = num1 + l1.val * count1;

        long num2 = 0;
        long count2 = 1;
        while (l2.next != null) {
            num2 = num2 + l2.val * count2;
            count2 *= 10;
            l2 = l2.next;
        }
        num2 = num2 + l2.val * count2;

        long num = num1 + num2;
        ListNode l3 = new ListNode((int) (num % 10));
        ListNode tempNode = l3;
        num = num / 10;

        while (num != 0) {
            tempNode.next = new ListNode((int) (num % 10));
            num = num / 10;
            tempNode = tempNode.next;
        }
        return l3;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        AddTwoNums addTwoNums = new AddTwoNums();
        ListNode listNode = addTwoNums.addTwoNumbers(node, node10);
        System.out.println(listNode.val);

        System.out.println(100000000000L % 10);

        System.out.println(10000000000L + 9L);

        System.out.println((int) (10000000000L % 10L));
        System.out.println((int) 10000000000L);
        System.out.println((2+3)/2);
    }
}
