package com.xunhuan.java.designmodel.dynamicproxy.first;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tianhuan
 * @date 2019-02-27 11:51
 **/
public class MyInvocationHandle implements InvocationHandler {
    private Bird bird;

    public MyInvocationHandle(Bird bird) {
        this.bird = bird;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object o = method.invoke(bird, args);
        System.out.println("after");
        return o;
    }
}
