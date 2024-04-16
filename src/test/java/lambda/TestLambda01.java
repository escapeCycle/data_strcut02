package lambda;

import com.xunhuan.java.enums.Status;
import com.xunhuan.java.model.Employee;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

/**
 * @author tianhuan
 * @date 2018-09-28 11:56
 **/
public class TestLambda01 {

    List<Employee> employees = Arrays.asList(
            new Employee("1", 18, 9999.99, Status.BUSY),
            new Employee("2", 28, 8888.88, Status.FREE),
            new Employee("3", 60, 6666.66, Status.BUSY),
            new Employee("4", 100, 3333.33, Status.BUSY),
            new Employee("5", 200, 1111.11, Status.ING)
    );


    @Test
    public void test() {
        employees.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);
    }

    @Test
    public void test01() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("hello");
    }

    @Test
    public void test02() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("hello");
            return Integer.compare(x, y);
        };
        com.compare(1, 2);
    }

    @Test
    public void test03() {
        CountDownLatch cc = new CountDownLatch(10000);
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            ints.add(i);
        }

        List<Integer> res = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(res);

        ints.parallelStream().forEach(i -> {
            synchronizedList.add(i);
            res.add(i);
            cc.countDown();
        });

        try {
            cc.await();
            synchronizedList.forEach(System.out::println);
            System.out.println("--------------------");
            res.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("iPhone");
        list.add("Windows Mobile");

        // Which Code will throw ConcurrentModificationException, both,
        // none or one of them

        // example 1
//        Iterator<String> itr = list.iterator();
//        while(itr.hasNext()){
//            String lang = itr.next();
//            list.remove(lang);
//        }

        // example 2
        for (String language : list) {
            if (language.equals("iPhone")) {
                list.remove(language);
            }
        }
        String a = "168.10.10.1";

        System.out.println(Math.abs(a.hashCode()));
    }


    private Long hash(String nodeName, int number) {
        byte[] digest = md5(nodeName);
        return (((long) (digest[3 + number * 4] & 0xFF) << 24)
                | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                | (digest[number * 4] & 0xFF))
                & 0xFFFFFFFFL;
    }
    /**
     * md5加密
     * @param str
     * @return
     */
    public byte[] md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes("UTF-8"));
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
