package com.xunhuan.java.thread.juc;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * FIFO 队列:
 * {@link java.util.concurrent.LinkedBlockingQueue,java.util.concurrent.ArrayBlockingQueue}
 * <p>
 * 优先级队列:
 * {@link java.util.concurrent.PriorityBlockingQueue}
 *
 * take()和put()均为阻塞方法，队列为空take将阻塞，直到队列中有内容，队列已满put将阻塞，直到队列有空位置
 * taske和put阻塞都是有条件的，队列不为空或队列不满是不会阻塞的
 * */
public class BlockingQueueExample {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static AtomicInteger count = new AtomicInteger(0);

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product" + count.incrementAndGet());
                System.out.println("produce  ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {

                String product = queue.take();
                System.out.println("consume : " + product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }

    }

}
