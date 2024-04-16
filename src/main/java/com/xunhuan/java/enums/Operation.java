package com.xunhuan.java.enums;

import java.util.function.DoubleBinaryOperator;

/**
 * 枚举类lambda用法
 */
public enum Operation {
    //PLUS("+") {
    //    public double apply(double x, double y) {
    //        return x + y;
    //    }
    //},
    //MINUS("-") {
    //    public double apply(double x, double y) {
    //        return x - y;
    //    }
    //},
    //TIMES("*") {
    //    public double apply(double x, double y) {
    //        return x * y;
    //    }
    //},
    //DIVIDE("/") {
    //    public double apply(double x, double y) {
    //        return x / y;
    //    }
    //};
    //private final String symbol;
    //
    //Operation(String symbol) {
    //    this.symbol = symbol;
    //}
    //
    //@Override
    //public String toString() {
    //    return symbol;
    //}
    //
    //public abstract double apply(double x, double y);

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    public static void main(String[] args) {
        double apply = Operation.DIVIDE.apply(1, 2);
        System.out.println(apply);
    }
}