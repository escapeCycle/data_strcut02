package com.xunhuan.java.designmodel.strategy.example;

/**
 * @author tianhuan
 * @date 2019-03-02 20:53
 **/
public class Car implements CarFunction {
    /**
     * 给子类使用
     */
    protected String name;
    protected String color;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color +" 的 "+ name + "在行驶");
    }
}
