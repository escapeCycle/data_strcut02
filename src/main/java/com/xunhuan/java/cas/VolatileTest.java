package com.xunhuan.java.cas;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *
 * 确认线程池中所有线程执行完毕
 * 1、awaitTermination  方法
 * 2、当pool.getTaskCount() == pool.getCompletedTaskCount();时候
 * @author tianhuan
 * @date 2019-02-12 11:43
 **/
public class VolatileTest {

    public static volatile int race = 0;

    private static final int THREADS_COUNT = 10;

    public static AtomicInteger race2 = new AtomicInteger(0);
    private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);

    public static synchronized void increase() {
        race++;
    }

    public static void increase2() {
        race2.getAndIncrement();  // 原子操作
    }

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();

        // 创建一个10个线程的线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    increase();
//                }
//            });
//            threads[i].start();

            pool.submit(() -> {
                for (int j = 0; j < 1000; j++) {
//                    increase();
                    increase2();
                }
            });
        }
        System.out.println("----------------");
        pool.shutdown();
        /*
            等待所有累加线程都结束
         */
//        while (Thread.activeCount() > 2){
//            System.out.println(Thread.activeCount());
//            Thread.yield();
//        }

        /*
            当线程池完成的线程数等于线程池中的总线程数
         */
        boolean allThreadsIsDone = pool.getTaskCount() == pool.getCompletedTaskCount();
        System.out.println(allThreadsIsDone);
        if (allThreadsIsDone) {
            System.out.println("全部执行完成");
//            System.out.println(race);
            System.out.println(race2);
        }
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部执行完成");
//        System.out.println(race);
        System.out.println(race2);
//        while (!allThreadsIsDone) {
//            allThreadsIsDone = pool.getTaskCount() == pool.getCompletedTaskCount();
//            if (allThreadsIsDone) {
//                System.out.println("全部执行完成");
//                System.out.println(race);
//            }
//        }
    }
}
