package com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.factory_method;

import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.IRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.JsonRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.XmlRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.YamlRuleConfigParser;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 14:12
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser(String configFormat);
}
