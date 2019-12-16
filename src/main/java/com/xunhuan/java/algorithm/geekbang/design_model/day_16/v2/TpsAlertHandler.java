package com.xunhuan.java.algorithm.geekbang.design_model.day_16.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.AlertRule;
import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.Notification;
import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.NotificationEmergencyLevel;

public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
