package com.xunhuan.java.designmodel.strategy.example;

/**
 * @author tianhuan
 * @date 2019-03-02 21:01
 **/
public class Client {

    public static void main(String[] args) {
        Car car1 = new SmallCar("QQ", "红色");
        Car car2 = new BusCar("公交车", "蓝色");

        Person person1 = new Person("小二", 22);
        person1.driver(car1);
        person1.driver(car2);



//        Person person2 = new Person("小二", 22, car1);
//        person2.driver2();
//
//        Person person3 = new Person("小二", 22, car2);
//        person3.driver2();
    }
}
