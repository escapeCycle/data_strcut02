package com.xunhuan.java.algorithm.geekbang.design_model.day_29.pending_behavior;

import java.util.Date;

/**
 * 单测，未决行为示例
 */
public class Demo {

    public long caculateDelayDays(Date dueTime) {
        long currentTimestamp = getCurrTime();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / (3600 * 24 * 1000);
        return delayDays;
    }


    protected long getCurrTime(){
        return System.currentTimeMillis();
    }
}
