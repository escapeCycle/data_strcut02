package com.xunhuan.java.thread.aqs;

import com.xunhuan.java.thread.util.ThreadPoolInstance;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier test
 *
 * 和CountdownLatch类似，也是计数器形式来协调线程，await操作会将计数器 -1 并阻塞住当前线程，
 * 直到计数器为0的时候所有线程才往下执行
 */
public class CyclicBarrierExample {


    public static void main(String[] args) {
        int threadCount = 10;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < 10; i++) {
            ThreadPoolInstance.threadPoolExecutor.execute(() ->{
                System.out.println("before");
                try {

                    cyclicBarrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("after");
            });
        }

        ThreadPoolInstance.threadPoolExecutor.shutdown();

    }
}
