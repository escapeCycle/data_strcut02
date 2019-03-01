package com.xunhuan.java.java8.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author tianhuan
 * @date 2019-01-20 11:09
 **/
@Data
@ToString
@AllArgsConstructor
public class Person {
    private String userName;
    private int age;
}
