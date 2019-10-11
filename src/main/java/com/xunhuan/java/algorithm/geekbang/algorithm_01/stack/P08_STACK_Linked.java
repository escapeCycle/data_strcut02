package com.xunhuan.java.algorithm.geekbang.algorithm_01.stack;

/**
 * @author tianh
 */
public class P08_STACK_Linked {

    private ListNode head = null;

    private Integer size = 0;

    /**
     * 入栈
     *
     * @param value
     */
    public void push(String value) {
        ListNode newNode = new ListNode(value);
        /**
         * 判断栈是否为空
         */
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {

        if (head == null) {
            return null;
        }
        String val = head.val;
        head = head.next;
        if (this.size > 0) {
            this.size--;
        }
        return val;
    }

    /**
     * 获取栈顶数据
     *
     * @return
     */
    public String getTopData() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    /**
     * 清空栈元素
     */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }


    public void printAll() {
        ListNode cur = head;
        while (cur.next != null) {
            System.out.println(cur.val + ",");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

    }

    private class ListNode {

        String val;
        ListNode next;

        ListNode(String x) {
            val = x;
            next = null;
        }
    }
}

