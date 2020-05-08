package com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.model.RequestInfo;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        MetricsCollector metricsCollector = new MetricsCollector(metricsStorage);

        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage);
        consoleReporter.startRepeatedReport(60, 60, TimeUnit.SECONDS);

        EmailReporter emailReporter = new EmailReporter(metricsStorage);
        emailReporter.startRepeatedReport(24,60,TimeUnit.DAYS);

        metricsCollector.recordRequest(new RequestInfo("register", 123, 10234));
        metricsCollector.recordRequest(new RequestInfo("register", 223, 11234));
        metricsCollector.recordRequest(new RequestInfo("register", 323, 12334));
        metricsCollector.recordRequest(new RequestInfo("login", 23, 12434));
        metricsCollector.recordRequest(new RequestInfo("login", 1223, 14234));


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
