package com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.factory_method;

import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.IRuleConfigParser;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianh
 * @description: 工厂的工厂
 * //因为工厂类只包含方法，不包含成员变量，完全可以复用，
 * //不需要每次都创建新的工厂类对象，所以，简单工厂模式的第二种实现思路更加合适。
 * @date 2020-05-07 14:32
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String,IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory createParser(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("参数异常");
        }
        IRuleConfigParserFactory parser = cachedFactories.get(type.toLowerCase());
        return parser;
    }
}
