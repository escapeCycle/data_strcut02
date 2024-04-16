package com.xunhuan.java.algorithm.geekbang.design_model.day_48.dynamic_proxy;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.MetricsCollector;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.RedisMetricsStorage;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.model.RequestInfo;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.IUserController;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.UserController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tianh
 * @description:
 * @date 2020-05-09 11:37
 */
public class MetricsCollectorProxy {
    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
    }


    public class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }


    public static void main(String[] args) {
        MetricsCollectorProxy metricsCollectorProxy = new MetricsCollectorProxy();
        IUserController iUserController = (IUserController) metricsCollectorProxy.createProxy(new UserController());
        iUserController.login("","");
    }
}
