package com.xunhuan.java.thread.guardthread;

/**
 * @author tianhuan
 * @date 2019-03-07 17:31
 **/
public class GuardThreadTest {


    public static void main(String[] args) {
        Sub sub = new Sub("1线程");
        Sub sub1 = new Sub("2线程");

        sub.setDaemon(true);
//        sub1.setDaemon(true);
        sub.start();
        sub1.start();


        Thread.currentThread().setName("老大");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

class Sub extends Thread {

    public Sub(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "--->" + i);
        }
    }
}