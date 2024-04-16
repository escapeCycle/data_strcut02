package com.xunhuan.java.thread.problem.second;

import java.util.concurrent.locks.LockSupport;

/**
 * @author tianh
 * @description: LockSupport
 * @date 2022/6/23 11:10
 */
public class T01_LockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] aI = {'1', '2', '3', '4', '5', '6'};
        char[] aC = {'A', 'B', 'C', 'D', 'E', 'F'};
        t1 = new Thread(() -> {
            for (char c : aC) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (char c : aI) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);

            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
