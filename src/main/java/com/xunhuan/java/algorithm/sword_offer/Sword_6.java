package com.xunhuan.java.algorithm.sword_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头反过来打印出每个结点的值。
 * 1、翻转链表
 * 2、使用栈
 * 3、递归
 *
 * @author tianhuan
 * @date 2019-04-19 15:28
 **/
public class Sword_6 {

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if(listNode == null) return null;
        /**
         * 构建头结点
         */
        ListNode head = new ListNode(-1);
        /**
         * 翻转链表
         */
        while (listNode != null) {
            ListNode next = listNode.next;  // 记录下一个节点
            listNode.next = head.next;  // 将当前的节点的下个节点 = 头结点的下一个节点
            head.next = listNode;  // 头结点的下一个节点 = 当前节点
            listNode = next;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        head = head.next;
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }

        return arrayList;
    }

    /**
     * 使用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead3(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        Sword_6 sword_6 = new Sword_6();
        ArrayList<Integer> list = sword_6.printListFromTailToHead3(listNode);
        list.forEach(System.out::println);
    }
}
