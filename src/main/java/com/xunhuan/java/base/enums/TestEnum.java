package com.xunhuan.java.base.enums;

import lombok.Getter;

/**
 * tianh
 */
@Getter
public enum TestEnum implements Show{

    FIRST("FIRST","第一"){
        @Override
        public void show() {
            System.out.println("first");
        }

        @Override
        public TestEnum res() {
            return SECOND;
        }

        @Override
        public void test() {
            System.out.println("test one");
        }
    },
    SECOND("SECOND","第二"){
        @Override
        public void show() {
            System.out.println("second");
        }

        @Override
        public TestEnum res() {
            return THIRD;
        }

        @Override
        public void test() {
            System.out.println("test two");
        }
    },
    THIRD("THIRD","第三"){
//        @Override
//        public void show() {
//            System.out.println("third");
//        }
//
//        @Override
//        public com.xunhuan.java.base.enums.TestEnum res() {
//            return null;
//        }


        @Override
        public void test() {
            System.out.println("test third");
        }
    };

    private String a;
    private String b;

    TestEnum(String a, String b) {
        this.a = a;
        this.b = b;
    }



    public static void main(String[] args) {
        TestEnum.THIRD.show();
        System.out.println(TestEnum.THIRD.res());
    }

    @Override
    public void show() {
        System.out.println("default");
    }

    @Override
    public TestEnum res() {
        return null;
    }

    public abstract void test();  //抽象方法
}
