package com.xunhuan.java.thread.problem.second;

import java.util.concurrent.CountDownLatch;

/**
 * @author tianh
 * @description: synchronized & CountDownLatch 保证执行顺序
 * @date 2022/6/23 11:10
 */
public class T03_Sync_wait_notify {

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        final Object o = new Object();

        char[] aI = {'1', '2', '3', '4', '5', '6'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F'};
        new Thread(() -> {
            // 保证第二个线程先执行
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o) {
                try {
                    for (char c : aC) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                o.notify();
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (o) {
                try {
                    for (char c : aI) {
                        System.out.print(c);
                        latch.countDown();
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                o.notify();
            }
        }, "t2").start();
    }
}
