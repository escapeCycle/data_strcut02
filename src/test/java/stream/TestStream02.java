package stream;

import com.xunhuan.java.enums.Status;
import com.xunhuan.java.model.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tianhuan
 * @date 2018-10-09 22:21
 **/
public class TestStream02 {
    List<Employee> employees = Arrays.asList(
            new Employee("1",18,9999.99,Status.BUSY),
            new Employee("2",28,8888.88,Status.FREE),
            new Employee("3",60,6666.66,Status.BUSY),
            new Employee("4",100,3333.33,Status.BUSY),
            new Employee("5",200,1111.11,Status.ING),
            new Employee("5",200,2222.11,Status.FREE)
    );

    /**
     * 筛选与切片
     * filter  接收lambda,从流中排除元素
     * limit 截断流
     * skip(n) 跳过元素 返回一个扔掉了前n个元素的流。若不满n个，返回一个空流 与limit互补
     * distinct 通过流生成的元素的hashcode和equals() 去掉重复元素
     */
    @Test
    public void test01(){
        Stream<Employee> stream1 = employees.stream().filter((e) -> e.getAge() > 30);
        stream1.forEach(System.out::println);

        Stream<Employee> stream2 = employees.stream()
                .filter((e) -> e.getAge() > 30)
                .limit(2);
    }

    /**
     * 映射
     * map 接收lambda 将函数转换成其他形式或提取信息 接收一个函数作为参数 该函数会被应用到每个元素上, 并将其映射成一个新的元素
     * flatmap 接收一个函数作为参数 将流中的每个值都换成另一个流 然后把所有流连接成一个流
     */
    @Test
    public void test02(){
        List<String> lists = Arrays.asList("aaa","bbb","ccc","ddd");
        lists.stream().map(String::toUpperCase)
                        .forEach(System.out::println);

        employees.stream().map(Employee::getAge).forEach(System.out::println);

        /**
         * flatmap
         *
         */
        Stream<Stream<Character>> stream = lists.stream().map(TestStream02::filterCharacter);
        // {{a,a,a},{b,b,b},...}
        stream.forEach((s) -> {
            s.forEach(System.out::println);
        });

        System.out.println("--------------------------------");

        Stream<Character> stream1 = lists.stream().flatMap(TestStream02::filterCharacter);
        // {a,a,a,b,b,b,...}
        stream1.forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> lists = new ArrayList<>();
        for (Character c:str.toCharArray()) {
            lists.add(c);
        }
        return lists.stream();
    }

    /**
     * 归约 reduce
     * map-reduce 模式
     */
    @Test
    public void test03(){
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = lists.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);


        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }

    /**
     * 收集  collect 将留转换为其他形式  接受一个Collector接口的实现, 用于给Stream中元素做汇总的方法
     */
    @Test
    public void test04(){
        List<String> lists = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        lists.forEach(System.out::println);

        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        lists.forEach(System.out::println);
        set.forEach(System.out::println);

        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);

        /**
         * 总数
         */
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        /**
         * 平均值
         */
        Double aDouble = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(aDouble);

        /**
         * 总和
         */

        Double aDouble1 = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(aDouble1);

        Double aDouble2 = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(aDouble1);

        /**
         * 最大值 最小值
         */
        Optional<Employee> maxE = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getAge(), e2.getAge())));

        Optional<Employee> maxE2 = employees.stream().max(Comparator.comparingDouble(Employee::getAge));

        Optional<Integer> minE = employees.stream()
                .map(Employee::getAge)
                .collect(Collectors.minBy(Integer::compare));

        System.out.println(maxE.get()+"----"+minE.get());


    }

    /**
     * 分组
     * 多级分组
     */
    @Test
    public void test05(){
        /**
         * 分组
         */
        Map<Status, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        Map<Status, Map<String, List<Employee>>> map1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map1);

        /**
         * 分区
         */
        Map<Boolean, List<Employee>> map2 = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(map2);

    }


}

