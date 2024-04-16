package com.xunhuan.java.thread.problem.four;

import com.xunhuan.java.utils.SleepHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author tianh
 * @description: 监听者设置回调函数
 * @date 2022/6/24 15:50
 */
public class T04_CompletableFuture {

    private static List<Worker> workers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Worker t1 = new Worker("t1", 10, true);
        Worker t2 = new Worker("t2", 5, true);
        Worker t3 = new Worker("t3", 1, false);
        workers.add(t1);
        workers.add(t2);
        workers.add(t3);

        for (Worker w : workers) {
            CompletableFuture c = CompletableFuture.supplyAsync(w::runTask).
                    thenAccept(result -> callback(result, w));
        }
        TimeUnit.SECONDS.sleep(20);
    }

    private static Result callback(Result result, Worker worker) {
        if (Result.FAILED.equals(result)) {
            for (Worker w : workers) {
                if (w != worker) {
                    w.cancel();
                }
            }
        }
        return result;
    }

    private static enum Result {
        NOT_END, SUCCESSED, FAILED;
    }


    private static class Worker {
        private Result result;
        private String name;
        private int timeInSeconds;
        private boolean success;

        private boolean cancelling;
        private boolean cancelled;

        public Worker(String name, int timeInSeconds, boolean success) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.success = success;
        }

        public Result getResult() {
            return result;
        }

        public Result runTask() {
            SleepHelper.sleepSeconds(timeInSeconds);
            System.out.println(name + ", 任务结束");
            result = success ? Result.SUCCESSED : Result.FAILED;
            return result;
        }

        public void cancel() {
            cancelling = true;
            synchronized (this) {
                System.out.println("cancelling");
                SleepHelper.sleepSeconds(5);
                System.out.println("cancelled");
            }
            cancelled = true;
        }
    }
}
