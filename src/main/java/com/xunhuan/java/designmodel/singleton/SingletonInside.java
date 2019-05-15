package com.xunhuan.java.designmodel.singleton;

/**
 * 静态内部类 线程安全
 *
 * @author tianhuan
 * @date 2019-04-20 22:03
 **/
public class SingletonInside {

    private SingletonInside() {
    }

    private static class SingletonHandle {
        private static final SingletonInside INSTANCE = new SingletonInside();
    }

    public static SingletonInside getInstance() {
        return SingletonHandle.INSTANCE;
    }
}
