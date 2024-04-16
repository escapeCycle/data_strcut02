package com.xunhuan.java.thread.problem.second;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianh
 * @description: ReentrantLock & Condition
 * @date 2022/6/23 11:10
 */
public class T04_Lock_condition {

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        char[] aI = {'1', '2', '3', '4', '5', '6'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F'};
        new Thread(() -> {
            // 保证第二个线程先执行
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            lock.lock();
            try {
                for (char c : aC) {
                    System.out.print(c);
                    condition.signal();// o.notify();
                    condition.await();// o.wait();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();
        new Thread(() -> {
            lock.lock();
            try {
                for (char c : aI) {
                    System.out.print(c);
                    latch.countDown();
                    condition.signal();// o.notify();
                    condition.await();// o.wait();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
