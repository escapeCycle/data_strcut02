package com.xunhuan.java.thread.problem.four;

import com.xunhuan.java.utils.SleepHelper;

/**
 * @author tianh
 * @description:
 * @date 2022/6/24 15:50
 */
public class T00_Task {


    public static void main(String[] args) {
        MyTask t1 = new MyTask("t1", 10, true);
        MyTask t2 = new MyTask("t2", 5, true);
        MyTask t3 = new MyTask("t3", 1, false);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class MyTask extends Thread {
        private String name;
        private int timeInSeconds;
        private boolean success;

        public MyTask(String name, int timeInSeconds, boolean success) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.success = success;
        }

        @Override
        public void run() {
            SleepHelper.sleepSeconds(timeInSeconds);
            System.out.println(name + ", 任务结束");
        }
    }
}
