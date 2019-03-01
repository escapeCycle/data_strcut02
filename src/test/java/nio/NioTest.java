package nio;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @author tianhuan
 * @date 2019-01-24 18:34
 **/
public class NioTest {


    @Test
    public void test(){
        char[] chars = new char[]{'a','b','c','d','e'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        charBuffer.limit(3);
        System.out.println();
    }
}
