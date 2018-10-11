package stream;

import com.xunhuan.java.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一 stream三个操作步骤
 * 1、创建stream
 * 2、中间操作
 * 3、终止操作(终端操作)
 * @author tianhuan
 * @date 2018-10-08 23:00
 **/
public class TestStream01 {

    /**
     * 创建stream
     */
    @Test
    public void test01(){

        // 1 可以通过Collection 系列集合提供的stream() 串行 或者parallelStream() 并行

        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2 通过Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 3 通过Stream类中静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2); // 从0开始 每次叠加2
        stream4.limit(10).forEach(System.out::println);

        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(System.out::println);
    }

}
