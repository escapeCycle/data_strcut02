package com.xunhuan.java.algorithm.geekbang.algorithm_01.queue;

/**
 * 基于链表的队列
 */
public class P09_BaseLinkedQueue {

    private ListNode head; // 头节点
    private ListNode tail; // 尾节点

    /**
     * 入队
     *
     * @param data
     */
    public void push(String data) {
        if (tail == null) {
            ListNode newNode = new ListNode(data, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new ListNode(data, null);
            tail = tail.next;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public String pop() {
        if (head == null) {
            return null;
        }
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    private class ListNode {
        private String data;
        private ListNode next;

        public ListNode(String data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    private void printAll() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + ",");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        P09_BaseLinkedQueue p09_baseLinkedQueue = new P09_BaseLinkedQueue();
        p09_baseLinkedQueue.push("1");
        p09_baseLinkedQueue.push("2");
        p09_baseLinkedQueue.push("3");
        p09_baseLinkedQueue.push("4");

        String pop = p09_baseLinkedQueue.pop();

        System.out.println(pop);
        p09_baseLinkedQueue.printAll();
    }
}
