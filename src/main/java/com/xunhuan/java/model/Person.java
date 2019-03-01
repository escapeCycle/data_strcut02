package com.xunhuan.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author tianhuan
 * @date 2018-11-06 14:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Optional<Car> car;


}
