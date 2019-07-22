package com.xunhuan.java.thread.aqs;

import com.xunhuan.java.thread.util.ThreadPoolInstance;

import java.util.concurrent.Semaphore;

/**
 * 信号量 ， 控制对互斥线程的线程访问数
 * <p>
 * 模拟：每次只有三个客户端同时访问，请求总数10
 */
public class SemaphoreExample {


    public static void main(String[] args) {
        int clientCount = 3;
        int totalRequest = 10;

        Semaphore semaphore = new Semaphore(clientCount);

        for (int i = 0; i < totalRequest; i++) {
            ThreadPoolInstance.threadPoolExecutor.execute(()->{
                try {
//                    System.out.println("初始可用许可："+Thread.currentThread().getName() + "数量：" +semaphore.availablePermits());
                    semaphore.acquire();
                    System.out.println("剩余许可数量："+Thread.currentThread().getName() + "数量：" +semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }

        ThreadPoolInstance.threadPoolExecutor.shutdown();

    }
}
