package com.xunhuan.java.algorithm.geekbang.algorithm_01.queue;


/**
 * 循环队列，基于数组
 * <p>
 * (tail+1)%n == head 满足条件时，证明队列已满
 * head == tail 满足条件，队列为空
 * 此方法会使队列有一位是空
 */
public class P09_CircularQueue {

    private String[] items; //元素
    private int capatity = 0; //容量

    private int head = 0; // 头下标
    private int tail = 0; //尾下标

    public P09_CircularQueue(int capatity) {
        items = new String[capatity];
        this.capatity = capatity;
    }


    /**
     * 入队
     * @param data
     * @return
     */
    public boolean push(String data) {
        //队列满，返回失败
        if ((tail + 1) % capatity == head) {
            return false;
        }

        items[tail] = data;
        tail = (tail + 1) % capatity; //向后移一位，加1后对容量取余, 找到下一个节点的索引（因为是环状的，需重复利用下标，所以取余）
        return true;
    }

    public String pop(){
        // 队列为空
        if(tail == head){
            return null;
        }
        String val = items[head];
        head = (head + 1) % capatity; // 向后取余
        return val;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        P09_CircularQueue p09_circularQueue = new P09_CircularQueue(6);
        p09_circularQueue.push("1");
        p09_circularQueue.push("2");
        p09_circularQueue.push("3");
        p09_circularQueue.push("4");
        p09_circularQueue.push("5");

        p09_circularQueue.pop();
        p09_circularQueue.pop();


        p09_circularQueue.printAll();
    }

}
