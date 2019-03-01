package com.xunhuan.java.designmodel.dynamicproxy.first;

import java.util.Random;

/**
 * @author tianhuan
 * @date 2019-02-26 16:55
 **/
public class Bird implements Flyable {
    @Override
    public void fly() {

        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopFly() {
        System.out.println("stop fly!");
    }
}
