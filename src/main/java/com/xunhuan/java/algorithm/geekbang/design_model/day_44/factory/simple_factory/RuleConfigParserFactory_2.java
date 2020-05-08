package com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.simple_factory;

import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.IRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.JsonRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.XmlRuleConfigParser;
import com.xunhuan.java.algorithm.geekbang.design_model.day_44.factory.YamlRuleConfigParser;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 14:12
 */
public class RuleConfigParserFactory_2 {

    public static final Map<String, IRuleConfigParser> cacheParser = new HashMap<>();

    static {
        cacheParser.put("json", new JsonRuleConfigParser());
        cacheParser.put("xml", new XmlRuleConfigParser());
        cacheParser.put("yaml", new YamlRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (StringUtils.isEmpty(configFormat)) {
            throw new IllegalArgumentException("参数异常");
        }
        IRuleConfigParser parser = cacheParser.get(configFormat.toLowerCase());
        return parser;
    }
}
