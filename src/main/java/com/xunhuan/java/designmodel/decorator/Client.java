package com.xunhuan.java.designmodel.decorator;

/**
 * @author tianhuan
 * @date 2019-03-03 20:34
 **/
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponet()));
        component.doSomething();
    }
}
