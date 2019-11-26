package com.xunhuan.java.algorithm.geekbang.design_model.day_08.abstracts;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

public class FileLogger extends Logger {
    private Writer fileWriter;
    public FileLogger(String name, boolean enabled, Level level, String filepath) throws IOException {
        super(name, enabled, level);
        this.fileWriter = new FileWriter(filepath);
    }

    @Override
    protected void dolog(Level level, String message) {
//        fileWriter.write(); //将日志写入到文件
    }
}
