package zhuzhen;

import org.junit.Test;

/**
 * @author tianhuan
 * @date 2019-01-11 16:14
 **/
public class MyIntegerTest {

    @Test
    public void name() {
        Integer  a = 1;
        int  b = 2;
        print1(a);
        print(b);
    }


    public void print1(int x) {
        System.out.println(x);
    }
//    public void print1(int x) {
//        System.out.println(x);
//    }

    public void print(Integer x) {
        System.out.println(x);
    }
    public void print(int x) {
        System.out.println(x);
    }

}
