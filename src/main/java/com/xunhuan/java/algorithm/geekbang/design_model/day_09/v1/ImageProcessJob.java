package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v1;

import java.awt.*;

/**
 * 图片处理流程
 */
public class ImageProcessJob {
    public static final String BUCKET_NAME = "images_bucket";

    public void process() {
        Image image = null;
        AliyunImageStore imageStore = new AliyunImageStore();
        imageStore.createBucketInfNotExisting(BUCKET_NAME);
        String token = imageStore.generateAccessToken();
        imageStore.uploadToAliyun(image, BUCKET_NAME, token);
    }

}
