package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2;

import java.awt.*;

/**
 * 图片存储操作(上传、下载)
 *
 */
public interface ImageStore {

    String upload(Image image, String bucketName);

    Image download(String url);
}
