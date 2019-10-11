package com.xunhuan.java.algorithm.geekbang.algorithm_01.queue;


/**
 *
 */
public class P09_DynamicArrayQueue {

    private String[] items; //元素
    private int capatity = 0; //容量

    private int head = 0; // 头下标
    private int tail = 0; //尾下标

    public P09_DynamicArrayQueue(int capatity) {
        items = new String[capatity];
        this.capatity = capatity;
    }


    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean push(String data) {
        if (tail == capatity) {  // 表示队尾没有空间了
            if (head == 0) {  //表示数组已满
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;

        }
        items[tail] = data;
        tail++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String pop() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        P09_DynamicArrayQueue arrayQueue = new P09_DynamicArrayQueue(5);
        arrayQueue.push("1");
        arrayQueue.push("2");
        arrayQueue.push("3");
        arrayQueue.push("4");
        arrayQueue.push("5");
        arrayQueue.push("6");

        arrayQueue.pop();

        arrayQueue.printAll();
    }


}
