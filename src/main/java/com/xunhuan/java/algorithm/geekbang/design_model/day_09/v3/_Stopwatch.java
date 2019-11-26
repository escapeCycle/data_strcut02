package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v3;

public class _Stopwatch {

  private final long start;

  public _Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }
}