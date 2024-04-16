package com.xunhuan.java.algorithm.sword_offer;

import java.util.Stack;

/**
 * @author tianh
 * @description: 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @date 2020-08-10 15:46
 */
public class Sword_9 {

    private Stack<Integer> leftS;
    private Stack<Integer> rightS;

    public Sword_9() {
        leftS = new Stack<>();
        rightS = new Stack<>();
    }

    public void appendTail(int value) {
        if (!leftS.isEmpty()) {
            while(!leftS.isEmpty()){
                rightS.push(leftS.pop());
            }
            leftS.push(value);
            while (!rightS.isEmpty()){
                leftS.push(rightS.pop());
            }
        } else {
            leftS.push(value);
        }
    }

    public int deleteHead() {
        if (!leftS.isEmpty()) {
            return leftS.pop();
        } else {
            return -1;
        }
    }

    public void appendTail2(int value) {
        while (!rightS.isEmpty()){
            leftS.push(rightS.pop());
        }
        leftS.push(value);
    }

    public int deleteHead2() {
        while(!leftS.isEmpty()){
            rightS.push(leftS.pop());
        }
        if (!rightS.isEmpty()) {
            return rightS.pop();
        }else{
            return -1;
        }
    }


    public static void main(String[] args) {
        Sword_9 sword_9 = new Sword_9();
        //sword_9.appendTail(123);
        //sword_9.appendTail(456);
        //sword_9.appendTail(789);

        System.out.println(sword_9.deleteHead());
    }
}
