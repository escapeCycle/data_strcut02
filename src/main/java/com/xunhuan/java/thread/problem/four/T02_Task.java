package com.xunhuan.java.thread.problem.four;

import com.xunhuan.java.utils.SleepHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description: 监听者设置回调函数
 * @date 2022/6/24 15:50
 */
public class T02_Task {

    private static class Boss extends Thread{
        List<Worker> tasks = new ArrayList<>();

        public void addWorker(Worker worker){
            tasks.add(worker);
        }

        @Override
        public void run() {
            tasks.forEach(Thread::start);
        }

        // 回调函数
        public void end(Worker worker){
            if(Result.FAILED.equals(worker.getResult())){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Boss boss = new Boss();
        Worker t1 = new Worker(boss, "t1", 10, true);
        Worker t2 = new Worker(boss, "t2", 5,true);
        Worker t3 = new Worker(boss, "t3", 1, false);


        boss.addWorker(t1);
        boss.addWorker(t2);
        boss.addWorker(t3);

        //启动线程
        boss.start();

    }

    private static enum Result {
        NOT_END, SUCCESSED, FAILED;
    }


    private static class Worker extends Thread {
        private Result result;
        private String name;
        private int timeInSeconds;
        private boolean success;
        private Boss boss;

        public Worker(Boss boss,String name, int timeInSeconds, boolean success) {
            this.boss = boss;
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
            boss.end(this);
        }
    }
}
