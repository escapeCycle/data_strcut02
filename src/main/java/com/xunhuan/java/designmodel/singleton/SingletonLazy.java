package com.xunhuan.java.designmodel.singleton;

/**
 * 懒汉 线程不安全
 *
 * @author tianhuan
 * @date 2019-04-20 21:48
 **/
public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
