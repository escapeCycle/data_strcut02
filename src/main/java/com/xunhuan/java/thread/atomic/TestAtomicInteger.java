package com.xunhuan.java.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 类变量与局部变量
 * @author tianhuan
 * @date 2019-03-04 17:40
 **/
public class TestAtomicInteger {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.submit(new Test());
//        executorService.shutdown();
    }
}

class Test implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static int sum = 0;

    @Override
    public void run() {
        AtomicInteger atomicInteger2 = new AtomicInteger();
        for (int i = 0; i < 200; i++) {
            atomicInteger.getAndIncrement();
            atomicInteger2.getAndIncrement();
            sum++;
        }
        System.out.println("1: "+atomicInteger.get());
        System.out.println("2: "+atomicInteger2.get());
        System.out.println("3: "+sum);
    }
}
