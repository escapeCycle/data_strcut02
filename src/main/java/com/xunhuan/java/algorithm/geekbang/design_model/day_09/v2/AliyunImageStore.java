package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2;

import java.awt.*;

/**
 * 阿里云图片操作
 */
public class AliyunImageStore implements ImageStore {

    public AliyunImageStore() {
    }

    @Override
    public String upload(Image image, String bucketName) {
        createBucketInfo(bucketName);
        String accessToken = generateAccessToken();
        System.out.println("AliyunImageStore upload");
        return null;
    }

    @Override
    public Image download(String url) {
        return null;
    }

    private void createBucketInfo(String bucketName){
        /**
         * 业务代码
         */
    }

    private String generateAccessToken(){
        return "token";
    }
}
