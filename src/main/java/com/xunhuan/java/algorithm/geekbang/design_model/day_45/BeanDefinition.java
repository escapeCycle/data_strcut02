package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 17:56
 */
@Data
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> args = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }
    public void addConstructorArg(ConstructorArg constructorArg) {
        this.args.add(constructorArg);
    }

    public enum Scope {
        SINGLETON,
        PROTOTYPE
    }

    @Data
    public static class ConstructorArg {
        private boolean isRef;
        private Class type;
        private Object arg;
    }
}