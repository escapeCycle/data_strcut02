package com.xunhuan.java.designmodel.decorator;

/**
 * @author tianhuan
 * @date 2019-03-03 20:28
 **/
public class Decorator implements Component{
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
