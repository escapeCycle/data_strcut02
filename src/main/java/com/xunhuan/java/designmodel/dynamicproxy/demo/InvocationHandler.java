package com.xunhuan.java.designmodel.dynamicproxy.demo;

import java.lang.reflect.Method;

/**
 * Invocation handler.
 *
 * @author Scott Smith 2018-03-01 20:05
 */
public interface InvocationHandler {

    void invoke(Object proxy, Method method, Object[] args);
}
