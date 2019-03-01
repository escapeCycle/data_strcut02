package com.xunhuan.java.designmodel.dynamicproxy.demo;

/**
 * BirdLogProxy
 *
 * @author Scott Smith 2018-03-01 10:53
 */
public class BirdLogProxy implements Flyable {
    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }

    @Override
    public void stopFly() {

    }
}
