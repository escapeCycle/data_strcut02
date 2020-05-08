package com.xunhuan.java.algorithm.geekbang.design_model.day_46;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tianh
 * @description:  建造者模式
 * @date 2020-05-08 15:02
 */
@Getter
@ToString
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build() {
            /*
                校验放在build中，包括各个参数之间的约束
             */
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException(".");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException(".");
            }
            if (minIdle > maxIdle || minIdle > maxTotal) {
                throw new IllegalArgumentException(".");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException(".");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfig redisConnect = new Builder().setName("redisConnect").setMaxTotal(32).setMaxIdle(16).setMinIdle(8).build();
        System.out.println(redisConnect.toString());
    }
}
