package com.xunhuan.java.designmodel.singleton;

/**
 * 饿汉式 线程安全
 *
 * @author tianhuan
 * @date 2019-04-20 21:51
 **/
public class SingletonHungry {

    private static SingletonHungry singletonHungry = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return singletonHungry;
    }

}
