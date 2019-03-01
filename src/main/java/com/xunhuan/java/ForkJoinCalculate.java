package com.xunhuan.java;

import java.util.concurrent.RecursiveTask;

/**
 * fork join 计算总数
 *
 * @author tianhuan
 * @date 2018-10-13 17:36
 **/
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1231412141L;
    private long start;
    private long end;

    public static final long THRESHOLD = 100000;

    public ForkJoinCalculate(long start,long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THRESHOLD){
            long sum = 0;
            for (long i = start ; i <= end ; i++){
                sum = sum+i;
            }
            return sum;
        }else{

            long middle = (end - start) /2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork(); // 拆分子任务 同时压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
