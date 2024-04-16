package com.xunhuan.java.algorithm.geekbang.design_model.day_48.static_proxy;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.MetricsCollector;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.RedisMetricsStorage;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.model.RequestInfo;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.UserController;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.model.UserVo;

/**
 * @author tianh
 * @description: 继承方式提供代理类,记录方法响应参数及时间
 * @date 2020-05-09 11:25
 */
public class UserControllerProxy_v2 extends UserController {
    private MetricsCollector metricsCollector;

    public UserControllerProxy_v2() {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    @Override
    public UserVo login(String telephone, String password) {

        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }

    public static void main(String[] args) {
        UserController userController = new UserControllerProxy_v2();
    }
}
