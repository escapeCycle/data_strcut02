package com.xunhuan.java.designmodel.dynamicproxy.first;

import java.lang.reflect.Proxy;

/**
 * 静态代理
 * @author tianhuan
 * @date 2019-02-26 17:02
 **/
public class Test {

    public static void main(String[] args) {
//        Bird bird = new Bird();
//
//        BirdLogProxy log = new BirdLogProxy(bird);
//
//        BirdTimeProxy time = new BirdTimeProxy(log);
//        time.fly();

        new MyInvocationHandle(new Bird());

        Object o = Proxy.newProxyInstance(Flyable.class.getClassLoader(), new Class[]{Flyable.class}, new MyInvocationHandle(new Bird()));
        ((Flyable)o).fly();
        ((Flyable)o).stopFly();
    }
}
