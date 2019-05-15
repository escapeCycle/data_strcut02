package com.xunhuan.java.designmodel.singleton;

/**
 * 双重校验锁 线程安全
 *
 * @author tianhuan
 * @date 2019-04-20 18:11
 **/
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
