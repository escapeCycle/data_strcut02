package json;

public class Student {

    private String sid; // 学生id
    private String sname; // 学生姓名
    private int sage; // 学生年龄

    // 省略构造方法、setter和getter方法

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }
}