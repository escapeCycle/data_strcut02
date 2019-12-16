package com.xunhuan.java.algorithm.geekbang.design_model.day_16.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.AlertRule;
import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.Notification;
import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.NotificationEmergencyLevel;

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
