import org.apache.tools.ant.util.DateUtils;

import java.util.Date;

/**
 * @author tianhuan
 * @date 2018-11-21 18:54
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(3 | 9);
        System.out.println(3 & 9);
        //1575385381000
        System.out.println(DateUtils.format(new Date(1586102400000L),DateUtils.ISO8601_DATETIME_PATTERN));
    }
}
