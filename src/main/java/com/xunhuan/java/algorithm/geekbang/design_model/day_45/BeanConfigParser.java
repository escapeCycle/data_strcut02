package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

import java.io.InputStream;
import java.util.List;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 18:01
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContext);
}
