package com.xunhuan.java.designmodel.decorator;

/**
 * @author tianhuan
 * @date 2019-03-03 20:30
 **/
public class ConcreteComponet implements Component {

    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
