package com.xunhuan.java.algorithm.geekbang.design_model.day_16.message;

import com.xunhuan.java.algorithm.geekbang.design_model.day_16.model.Notification;

public class Demo {

    private MessageQueue queue; // 基于接口编程

    public Demo(MessageQueue queue) {
        this.queue = queue;
    }

    public void sendNotification(Notification notification,MessageFromatter messageFromatter){
        //...
    }

}
