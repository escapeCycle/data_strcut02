package com.xunhuan.java.algorithm.geekbang.design_model.day_25.v1;

import java.util.concurrent.TimeUnit;

public class UserController {
    private Monitor monitor = new Monitor();


    public UserController() {
        monitor.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    public void register() {
        double startTime = System.currentTimeMillis();

        monitor.recordResponseTimestamps("register", startTime);

        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double endTime = System.currentTimeMillis();
        monitor.recordResponseTime("register", endTime - startTime);
    }

    public void login() {
        double startTime = System.currentTimeMillis();

        monitor.recordResponseTimestamps("login", startTime);

        try {
            Thread.sleep(1500l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double endTime = System.currentTimeMillis();
        monitor.recordResponseTime("login", endTime - startTime);
    }
}
