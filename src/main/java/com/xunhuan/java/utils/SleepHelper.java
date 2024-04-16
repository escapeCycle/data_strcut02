package com.xunhuan.java.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tianh
 * @description:
 * @date 2022/6/22 17:00
 */
@Slf4j
public class SleepHelper {

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(Long.parseLong(String.valueOf(1000 * seconds)));
        } catch (InterruptedException e) {
            log.error(e.getMessage() + "-- sleep error", e);
        }
    }
}
