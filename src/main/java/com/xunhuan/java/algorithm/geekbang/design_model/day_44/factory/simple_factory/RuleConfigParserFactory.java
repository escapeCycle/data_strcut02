package com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.simple_factory;

import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.IRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.JsonRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.XmlRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.YamlRuleConfigParser;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 14:12
 */
public class RuleConfigParserFactory {

    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        }
        return parser;
    }
}
