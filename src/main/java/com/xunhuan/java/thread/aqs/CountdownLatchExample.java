package com.xunhuan.java.thread.aqs;

import com.xunhuan.java.thread.util.ThreadPoolInstance;

import java.util.concurrent.CountDownLatch;

/**
 * countdownlatch test
 *
 * 控制一个线程等待多个线程 维护了一个计数器
 */
public class CountdownLatchExample {


    public static void main(String[] args) throws InterruptedException {


        int threadCount = 10;

        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < 10; i++) {
            ThreadPoolInstance.threadPoolExecutor.execute(() ->{
                System.out.println("run");
                /**
                 * 每次计数器值会减 1 原子操作
                 */
                latch.countDown();
            });
        }
        /**
         * 阻塞直到计数器等于0的时候
         */
        latch.await();
        System.out.println("end");
        ThreadPoolInstance.threadPoolExecutor.shutdown();
    }

}

