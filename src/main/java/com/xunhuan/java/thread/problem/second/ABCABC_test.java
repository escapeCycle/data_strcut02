package com.xunhuan.java.thread.problem.second;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianh
 * @description: 三个线程分别输出 A、B、C ，最终输出ABCABC ， 使用ReentrantLock 定义三种队列，分别唤醒不同队列，打印该队列阻塞的线程
 * @date 2022/6/23 15:39
 */
public class ABCABC_test {

    private static ReentrantLock lock = new ReentrantLock();
    // 定义lock的三个队列
    private static Condition cA = lock.newCondition();
    private static Condition cB = lock.newCondition();
    private static Condition cC = lock.newCondition();

    private static CountDownLatch latchB = new CountDownLatch(1);
    private static CountDownLatch latchC = new CountDownLatch(1);


    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    System.out.print("A");
                    cB.signal();
                    if(i == 0) latchB.countDown(); // 第一次进入且打印A之后打开B
                    cA.await();
                }
                cB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {

            // 等待被唤醒
            try {
                latchB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    System.out.print("B");
                    cC.signal();
                    if(i == 0) latchC.countDown(); // 第一次进入且打印B之后打开C
                    cB.await();
                }
                cC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            // 等待被唤醒
            try {
                latchC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    System.out.print("C");
                    cA.signal();
                    cC.await();
                }
                cA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t3").start();
    }
}
