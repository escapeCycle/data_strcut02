package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

import lombok.Data;
import lombok.Getter;

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

    @Getter
    public static class ConstructorArg {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg(Builder builder) {
            this.isRef = builder.isRef;
            this.type = builder.type;
            this.arg = builder.arg;
        }

        public static class Builder {
            private boolean isRef;
            private Class type;
            private Object arg;

            public Builder setRef(boolean ref) {
                if (ref && this.type != null) {
                    throw new IllegalArgumentException("...");
                }
                isRef = ref;
                return this;
            }

            public Builder setType(Class type) {
                if (this.isRef || type == null) {
                    throw new IllegalArgumentException("...");
                }
                this.type = type;
                return this;
            }

            public Builder setArg(Object arg) {
                if (this.isRef && (arg != null && arg.getClass() != String.class)) {
                    throw new IllegalArgumentException("...");
                }
                if (!this.isRef && arg == null) {
                    throw new IllegalArgumentException("...");
                }
                this.arg = arg;
                return this;
            }

            public ConstructorArg build() {
                if (isRef && type != null) {
                    throw new IllegalArgumentException(".");
                }
                if (!isRef && (arg == null || type == null)) {
                    throw new IllegalArgumentException(".");
                }
                return new ConstructorArg(this);
            }
        }
    }
}