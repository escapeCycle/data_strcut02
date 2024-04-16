package json;

import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;

/**
 * @author tianh
 * @description:
 * @date 2021/5/14 7:07 下午
 */
public class JsonTest {


    public static void main(String[] args) {
        String text = "{\"code\":\"0000\",\"data\":{\"sage\":11,\"sid\":\"123\",\"sname\":\"yiyi\"},\"message\":\"success\"}";
        Class calassA = Student.class;


        BaseResponseBean o = FastJsonUtil.convertToBean(text, new Type[]{calassA}, BaseResponseBean.class);
        System.out.println(o);
    }
}
