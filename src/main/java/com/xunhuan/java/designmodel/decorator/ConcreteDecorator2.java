package com.xunhuan.java.designmodel.decorator;

/**
 * @author tianhuan
 * @date 2019-03-03 20:32
 **/
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        doAnotherThing();
    }

    private void doAnotherThing(){
        System.out.println("装饰C");
    }
}
