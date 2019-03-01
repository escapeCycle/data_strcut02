package com.xunhuan.java.designmodel.dynamicproxy.first;

import java.time.LocalDateTime;

/**
 * @author tianhuan
 * @date 2019-02-26 17:04
 **/
public class BirdTimeProxy implements Flyable {
    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = LocalDateTime.now().getNano();

        flyable.fly();

        long end = LocalDateTime.now().getNano();

        System.out.println("Fly time: " + (end - start));
    }

    @Override
    public void stopFly() {

    }
}
