package com.xunhuan.java.thread.problem.third;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianh
 * @description:
 * @date 2022/6/23 16:44
 */
public class ProducerAndConsumerByLock {

    private static int count = 0;
    private int maxNums = 3;

    ReentrantLock lock = new ReentrantLock();
    Condition producerC = lock.newCondition();
    Condition consumerC = lock.newCondition();


    public static void main(String[] args) {
        ProducerAndConsumerByLock test = new ProducerAndConsumerByLock();
        new Thread(test.new Producer()).start();
        new Thread(test.new Producer()).start();


        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();
    }


    class Producer implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count >= maxNums) {
                        producerC.await(); // awaait会释放锁 sleep不会释放锁
                        System.out.println("生产量已达上限, 进入等待, count: " + count);
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产, 目前数量: " + count);
                    consumerC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }


    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count <= 0) {
                        consumerC.await();
                        System.out.println("已经全部消费完, 等待生产, count: " + count);
                    }

                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费, 目前数量: " + count);
                    producerC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
