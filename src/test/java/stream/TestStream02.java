package stream;

import com.xunhuan.java.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author tianhuan
 * @date 2018-10-09 22:21
 **/
public class TestStream02 {
    List<Employee> employees = Arrays.asList(
            new Employee("1",18,9999.99),
            new Employee("2",28,8888.88),
            new Employee("3",60,6666.66),
            new Employee("4",100,3333.33),
            new Employee("5",200,1111.11)
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
}
