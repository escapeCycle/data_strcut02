package com.xunhuan.java.designmodel.dynamicproxy.first;

/**
 * @author tianhuan
 * @date 2019-02-26 17:00
 **/
public class BirdLogProxy implements Flyable {
    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("bird start fly");

        flyable.fly();

        System.out.println("bird start fly");
    }

    @Override
    public void stopFly() {

    }
}
