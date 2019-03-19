package com.xunhuan.java.designmodel.strategy.example;

/**
 * @author tianhuan
 * @date 2019-03-02 20:52
 **/
public class Person {

    private String name;
    private int age;
//    private Car car;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//
//    public Person(String name, int age, Car car) {
//        this.name = name;
//        this.age = age;
//        this.car = car;
//    }

    public void driver(Car car){
        System.out.println(name+ " " + age +"岁,开着" );
        car.run();
    }

//    public void driver2(){
//        System.out.println(name+ " " + age +"岁,开着" );
//        car.run();
//    }
}
