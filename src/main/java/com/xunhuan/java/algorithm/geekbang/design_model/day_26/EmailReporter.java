package com.xunhuan.java.algorithm.geekbang.design_model.day_26;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EmailReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

    public EmailReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startDailyReport() {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() { //...
            }
        }, 0, 24, TimeUnit.HOURS);
    }
}