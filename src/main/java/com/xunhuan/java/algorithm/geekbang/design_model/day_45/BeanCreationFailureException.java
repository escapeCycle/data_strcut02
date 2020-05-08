package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

/**
 * @author tianh
 * @description:
 * @date 2020-05-08 10:56
 */
public class BeanCreationFailureException extends RuntimeException {

    public BeanCreationFailureException(String message){
        super(message);
    }

    public BeanCreationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
