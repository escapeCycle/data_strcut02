package com.xunhuan.java.algorithm.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {

  /**
   * 关闭操作
   * @param stream
   */
  public static void Close(Closeable stream) {
    if (null != stream) {
      try {
        stream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}