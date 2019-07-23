package stream;

import com.xunhuan.java.thread.juc.ForkJoinCalculate;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author tianhuan
 * @date 2018-10-13 17:46
 **/
public class TestForkJoin {

    /**
     * fork join计算
     */
    @Test
    public void test01() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗費時間: " + Duration.between(start, end).toMillis());
    }

    /**
     * 并行流
     */
    @Test
    public void test02() {

        long sum = LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(sum);
    }
}
