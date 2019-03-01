package com.xunhuan.java.java8;

import com.xunhuan.java.java8.bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tianhuan
 * @date 2019-01-20 9:59
 **/
public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.comput(2, value -> value * 2));

        /*
            compose和andThen
         */
        System.out.println(functionTest.comput2(2, value -> value * 3, value -> value * value));
        System.out.println(functionTest.comput3(2, value -> value * 3, value -> value * value));

        /*
            bifunction应用
         */
        System.out.println(functionTest.comput4(1, 2, (value1, value2) -> value1 + value2));

        List<Person> personList = Arrays.asList(new Person("a", 15), new Person("b", 25), new Person("c", 35), new Person("d", 45), new Person("e", 55));

        List<Person> listByAge = functionTest.getListByAge(30, personList);
        listByAge.forEach(a -> System.out.println(a.toString()));
        System.out.println("------------------------");

        List<Person> listByAge2 = functionTest.getListByAge2(30, personList,
                (age, persons) -> persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList()));
        listByAge2.forEach(a -> System.out.println(a.toString()));

        System.out.println("------------------------");
        List<Person> listByAge3 = functionTest.getListByAge2(30, personList,
                (age, persons) -> persons.stream().filter(person -> person.getAge() <= age).collect(Collectors.toList()));
        listByAge3.forEach(a -> System.out.println(a.toString()));

    }

    public int comput(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public int comput2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int comput3(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    public int comput4(int a, int b, BiFunction<Integer, Integer, Integer> function) {
        return function.apply(a, b);
    }

    /**
     * 得到比输入年龄大的人员集合
     *
     * @param age
     * @param personList
     * @return
     */
    public List<Person> getListByAge(int age, List<Person> personList) {
//        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson,persons) -> {
//            return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
//        };
        BiFunction<Integer, List<Person>, List<Person>> biFunction =
                (ageOfPerson, persons) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        return biFunction.apply(age, personList);
    }

    public List<Person> getListByAge2(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }
}
