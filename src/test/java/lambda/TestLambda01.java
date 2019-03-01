package lambda;

import com.xunhuan.java.enums.Status;
import com.xunhuan.java.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author tianhuan
 * @date 2018-09-28 11:56
 **/
public class TestLambda01 {

    List<Employee> employees = Arrays.asList(
            new Employee("1",18,9999.99,Status.BUSY),
            new Employee("2",28,8888.88,Status.FREE),
            new Employee("3",60,6666.66,Status.BUSY),
            new Employee("4",100,3333.33,Status.BUSY),
            new Employee("5",200,1111.11,Status.ING)
    );


    @Test
    public void test(){
        employees.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);
    }

    @Test
    public void test01(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello");
    }

    @Test
    public void test02(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("hello");
            return Integer.compare(x,y);
        };
        com.compare(1,2);
    }
}
