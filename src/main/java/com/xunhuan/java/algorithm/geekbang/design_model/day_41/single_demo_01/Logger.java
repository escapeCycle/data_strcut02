package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single_demo_01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author tianh
 * @description: 由于每个调用都是new 一个新的logger ，所以即便加了sync对象锁也避免不了并发写入的时候，日志文件被覆盖问题，除非加上类级别的锁
 * @date 2020-04-15 15:57
 */
public class Logger {
    private FileWriter writer;

    public Logger() throws IOException {
        File file = new File("/Users/tianh/log.txt");
        writer = new FileWriter(file,true);//true 表示追加写入
    }

    public void log(String message) throws IOException {
        writer.write(message);
    }

    public void obSyncLog(String message) throws IOException {
        synchronized (this) {
            writer.write(message);
        }
    }

    public void classSyncLog(String message) throws IOException {
        synchronized (Logger.class){
            writer.write(message);
        }
    }
}
