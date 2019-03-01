package com.xunhuan.java.model;

import com.xunhuan.java.enums.Status;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author tianhuan
 * @date 2018-09-28 11:57
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
public class Employee {
    private String name;
    private int age;
    private double salary;
    private Status status;

}
