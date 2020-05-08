package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single_demo_02;

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
    public static final Logger instance = new Logger();

    private Logger() {
        File file = new File("/Users/tianh/log.txt");
        try {
            writer = new FileWriter(file,true);//true 表示追加写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        return instance;
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
