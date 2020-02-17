package com.xunhuan.java.algorithm.geekbang.design_model.day_34.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_34.v2.exception.IdGenerationFailureException;

public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
