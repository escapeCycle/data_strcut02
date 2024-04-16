package com.xunhuan.java.thread.problem.second;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author tianh
 * @description: TransferQueue
 * @date 2022/6/23 11:10
 */
public class T02_TransferQueue {

    public static void main(String[] args) {
        TransferQueue<Character> queue = new LinkedTransferQueue<Character>();

        char[] aI = {'1', '2', '3', '4', '5', '6'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F'};
        new Thread(() -> {
            try {
                for (char c : aC) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                for (char c : aI) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
