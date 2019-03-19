package com.xunhuan.java.designmodel.strategy.example;

/**
 * @author tianhuan
 * @date 2019-03-02 20:50
 **/
public class SmallCar extends Car {


    public SmallCar(String name, String color) {
        super(name,color);
    }

    @Override
    public void run() {
        System.out.println(color +" 的 "+ name + "在高速的行驶");
    }
}
