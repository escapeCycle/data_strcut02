package com.xunhuan.java.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianhuan
 * @date 2019-03-21 15:37
 **/
public class SynchronizedTest {
    private int a = 0;

    public synchronized void writer() {     // 1
        a++;                                // 2
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }                                       // 3

    public synchronized int reader() {    // 4
        int i = a;                         // 5
        return i;
    }                                      // 6


    public static void main(String[] args) {
        ExecutorService poll = Executors.newFixedThreadPool(10);
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        for (int i = 0; i < 10; i++) {
            poll.submit(() -> {
                for (int j = 0; j < 20; j++) {
                    synchronizedTest.writer();
                    System.out.println(synchronizedTest.reader());
                }
            });
        }
        System.out.println(synchronizedTest.reader());

        poll.shutdown();
    }
}
