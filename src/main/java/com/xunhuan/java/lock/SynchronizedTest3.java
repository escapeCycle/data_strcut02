package com.xunhuan.java.lock;

/**
 * @author tianhuan
 * @date 2019-03-21 17:26
 **/
public class SynchronizedTest3 implements Runnable{

    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedTest3());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        synchronized (SynchronizedTest3.class) {
            for (int i = 0; i < 1000000; i++)
                count++;
        }
    }
}
