package com.xunhuan.java.algorithm.geekbang.design_model.day_08.abstracts;

import java.util.logging.Level;

public class MessageQueueLogger extends Logger {
//    private MessageQueueClient msgQueueClient; // 示例，无具体类

    public MessageQueueLogger(String name, boolean enabled, Level level
//    ,MessageQueueClient msgQueueClient
    ) {
        super(name, enabled, level);
//        this.msgQueueClient = msgQueueClient;
    }

    @Override
    protected void dolog(Level level, String message) {
//      格式化level和message,输出到消息中间件
//      msgQueueClient.send(...);
    }
}
