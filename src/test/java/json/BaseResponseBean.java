package json;

import com.alibaba.fastjson.JSONObject;

public class BaseResponseBean<T> {
    public String message;
    public String code;
    public T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static void main(String[] args) {
        BaseResponseBean<Student> studentBaseResponseBean = new BaseResponseBean<>();
        Student student = new Student();
        student.setSage(11);
        student.setSname("yiyi");
        student.setSid("123");
        studentBaseResponseBean.setCode("0000");
        studentBaseResponseBean.setData(student);
        studentBaseResponseBean.setMessage("success");

        String s = JSONObject.toJSONString(studentBaseResponseBean);
        System.out.println(s);
    }
}