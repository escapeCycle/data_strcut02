package com.xunhuan.java.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 当一个计算需要很长时间的时候，异步获取结果
 */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10L);
                result += i;
            }
            return result;
        });

        Thread calc = new Thread(futureTask);
        calc.start();

        Thread waitThread = new Thread(() -> {
            System.out.println("wait 1000ms");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waitThread.start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get());
        System.out.println(futureTask.isDone());
    }
}
