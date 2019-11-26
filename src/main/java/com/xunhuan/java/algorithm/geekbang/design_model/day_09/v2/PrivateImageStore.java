package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2;

import java.awt.*;

/**
 * 私有云图片操作
 */
public class PrivateImageStore implements ImageStore {
    @Override
    public String upload(Image image, String bucketName) {
        createBucketInfNotExisting(bucketName);
        System.out.println("PrivateImageStore upload");
        return null;
    }

    @Override
    public Image download(String url) {
        return null;
    }

    private void createBucketInfNotExisting(String bucketName) {

    }
}
