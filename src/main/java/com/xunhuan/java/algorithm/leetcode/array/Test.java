package com.xunhuan.java.algorithm.leetcode.array;

/**
 * @author tianh
 * @description:
 * @date 2024/4/7 10:25
 */
public class Test {

    //{1,2,4,3,5},"RWRRW"

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param s    string字符串
     * @return int整型
     */
    public int minValue(ListNode head, String s) {
        // write code here
        if (head == null) {
            return 0;
        }
        int step = 0;
        int res = 0;
        char[] strChars = s.toCharArray();
        while (head.next != null) {
            ListNode tmp = head.next;
            if (strChars[step] == strChars[step + 1]) {
                res =  res + Math.min(head.val, tmp.val);
                if(head.val > tmp.val){
                    tmp.val = head.val;
                }
            }
            head = tmp;
            step++;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(7);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(6);
        ListNode listNode9 = new ListNode(10);
        ListNode listNode10 = new ListNode(1);
        ListNode listNode11 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        Test test = new Test();
        int www = test.minValue(listNode, "WWWRWRWRWWR");
        System.out.println(www);

    }

    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}

