package com.xunhuan.java.thread.problem.four;

import com.xunhuan.java.utils.SleepHelper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description:
 * @date 2022/6/24 15:50
 */
public class T01_Task {


    public static void main(String[] args) {
        MyTask t1 = new MyTask("t1", 10, true);
        MyTask t2 = new MyTask("t2", 5,true);
        MyTask t3 = new MyTask("t3", 1, false);

        List<MyTask> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        //启动线程
        tasks.forEach(Thread::start);

        // 设置一个监听
        for (; ; ) {
            for (MyTask task : tasks) {
                if (Result.FAILED.equals(task.getResult())) {
                    System.exit(0);
                }
            }
        }
    }

    private static enum Result {
        NOT_END, SUCCESSED, FAILED;
    }


    private static class MyTask extends Thread {
        private Result result;
        private String name;
        private int timeInSeconds;
        private boolean success;

        public MyTask(String name, int timeInSeconds, boolean success) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.success = success;
        }

        public Result getResult(){
            return result;
        }

        @Override
        public void run() {
            SleepHelper.sleepSeconds(timeInSeconds);
            System.out.println(name + ", 任务结束");
            result = success ? Result.SUCCESSED : Result.FAILED;
        }
    }
}
