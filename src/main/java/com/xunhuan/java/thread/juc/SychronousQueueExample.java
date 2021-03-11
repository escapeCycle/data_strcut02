package com.xunhuan.java.thread.juc;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *  SynchronousQueue 阻塞队列测试
 *  生产和消费交替进行
 *
 *
 *  result:
 *
 *  Added to queue-0
 *  Consumer retrieved- 0
 *  Added to queue-1
 *  Consumer retrieved- 1
 *  Added to queue-2
 *  Consumer retrieved- 2
 *  Added to queue-3
 *  Consumer retrieved- 3
 *  Added to queue-4
 *  Consumer retrieved- 4
 */
public class SychronousQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> bQueue = new SynchronousQueue<>();
        // Producer
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Added to queue-" + i);
                    bQueue.put(i);
                    Thread.sleep(200);
                    System.out.println("Added to queue finished-" + i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

        // Consumer
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Consumer retrieved- " + bQueue.take());

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }
}