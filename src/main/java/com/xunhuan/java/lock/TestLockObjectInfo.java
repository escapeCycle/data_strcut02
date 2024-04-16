package com.xunhuan.java.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author tianh
 * @description: 使用JOL 打印锁对象信息，可查看对象头情况
 * @date 2022/6/29 11:36
 */
public class TestLockObjectInfo {

    private static class T {

    }

    public static void main(String[] args) {

        T t = new T();


        System.out.println(ClassLayout.parseInstance(t).toPrintable());

        synchronized (t){
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }
    }
}
