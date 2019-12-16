package com.xunhuan.java.algorithm.geekbang.design_model.day_16.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.AlertRule;
import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.Notification;

public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification();

        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }

    //  饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        instance.initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public Alert getAlert() {
        return alert;
    }
}
