package com.xunhuan.java.thread.basic;

/**
 * 死锁状态线程无法被中断
 */
class InterruptExample4 extends Thread {
    public static void main(String args[]) throws Exception {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        Thread thread1 = new Thread(() -> deathLock(lock1, lock2));
        Thread thread2 = new Thread(() -> {
            // 注意，这里在交换了一下位置
            deathLock(lock2, lock1);
        });
        System.out.println("Starting thread...");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread...");
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    static void deathLock(Object lock1, Object lock2) {
        try {
            synchronized (lock1) {
                Thread.sleep(10);// 不会在这里死掉
                System.out.println(Thread.currentThread() + " sleep 10ms");
                synchronized (lock2) {// 会锁在这里，虽然阻塞了，但不会抛异常
                    System.out.println(Thread.currentThread());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}