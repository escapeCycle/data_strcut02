package com.xunhuan.java.algorithm.geekbang.design_model.day_16.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.AlertRule;
import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.Notification;

public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
