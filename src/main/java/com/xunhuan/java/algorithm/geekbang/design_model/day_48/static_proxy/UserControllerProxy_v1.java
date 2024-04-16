package com.xunhuan.java.algorithm.geekbang.design_model.day_48.static_proxy;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.MetricsCollector;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.RedisMetricsStorage;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.model.RequestInfo;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.IUserController;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.UserController;
import com.xunhuan.java.algorithm.geekbang.design_model.day_48.model.UserVo;

/**
 * @author tianh
 * @description: 组合方式提供代理类,记录方法响应参数及时间
 * 存在问题：被代理的类不是自己提供的，非接口方式的话，则无法使用此方式
 * @date 2020-05-09 11:25
 */
public class UserControllerProxy_v1 implements IUserController {
    private UserController userController;
    private MetricsCollector metricsCollector;

    public UserControllerProxy_v1(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    @Override
    public UserVo login(String telephone, String password) {

        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);

        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }

    public static void main(String[] args) {
        IUserController userController = new UserControllerProxy_v1(new UserController());
    }
}
