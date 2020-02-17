package com.xunhuan.java.algorithm.geekbang.design_model.day_29.pending_behavior;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

public class TestDemo {

    @Test
    public void test() {
        Demo demo = new Demo() {
            @Override
            protected long getCurrTime() {
                Calendar c = Calendar.getInstance();
                c.set(2020, 1, 14);
                System.out.println(System.currentTimeMillis());
                System.out.println(c.getTimeInMillis());
                return c.getTimeInMillis();
            }
        };

        Calendar c = Calendar.getInstance();
        c.set(2020, 1, 1);
        Date dueTime = c.getTime();

        long delayDays = demo.caculateDelayDays(dueTime);
        System.out.println(delayDays);
        assertEquals(delayDays, 13l);
    }
}