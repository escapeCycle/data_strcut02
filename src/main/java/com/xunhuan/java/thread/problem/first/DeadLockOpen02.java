package com.xunhuan.java.thread.problem.first;

import com.xunhuan.java.utils.SleepHelper;

/**
 * @author tianh
 * @description:
 * @date 2022/6/22 17:14
 */
public class DeadLockOpen02 {
    public static void main(String[] args) {
        // 共五双筷子
        ChopStick c0 = new ChopStick();
        ChopStick c1 = new ChopStick();
        ChopStick c2 = new ChopStick();
        ChopStick c3 = new ChopStick();
        ChopStick c4 = new ChopStick();

        // 五个哲学家
        Philosopher p0 = new Philosopher("p0", 0, c0, c1);
        Philosopher p1 = new Philosopher("p1", 1, c1, c2);
        Philosopher p2 = new Philosopher("p2", 2, c2, c3);
        Philosopher p3 = new Philosopher("p3", 3, c3, c4);
        Philosopher p4 = new Philosopher("p4", 4, c4, c0);

        // 因为有循环占用资源问题，会产生死锁
        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();

    }


    public static class Philosopher extends Thread {
        private ChopStick left, right;
        private int index;

        public Philosopher(String name, int index, ChopStick left, ChopStick right) {
            this.setName(name);
            this.left = left;
            this.right = right;
            this.index = index;
        }

        @Override
        public void run() {
            // 混进一半左撇子 ，提升效率
            if (index % 2 == 0) {
                synchronized (right) {
                    SleepHelper.sleepSeconds(1 + index);
                    synchronized (left) {
                        System.out.println(getName() + "-正在吃饭");
                        SleepHelper.sleepSeconds(1);
                    }
                }
            } else {
                synchronized (left) {
                    SleepHelper.sleepSeconds(1 + index);
                    synchronized (right) {
                        System.out.println(getName() + "-正在吃饭");
                        SleepHelper.sleepSeconds(1);
                    }
                }
            }

        }
    }
}
