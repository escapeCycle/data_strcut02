package com.xunhuan.java.designmodel.templete;

/**
 * 模版模式
 */
public class Client {

    public static void main(String[] args) {
        AbstractClass clazz = new ConcreteClass();
        clazz.templete();
    }
}
