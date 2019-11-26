package com.xunhuan.java.algorithm.geekbang.design_model.day_08.abstracts;

import java.util.logging.Level;

public abstract class Logger {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level level) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = level;
    }

    public Logger(Level level, String message) {
        boolean logable = enabled && (minPermittedLevel.intValue() <= level.intValue());
        if (!logable) {
            return;
        }
        dolog(level, message);
    }

    protected abstract void dolog(Level level, String message);
}