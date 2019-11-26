package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2;

/**
 * 图片操作工厂类
 */
public class ImageStoreFactory {

    public ImageStoreFactory() {
    }

    private static final String PRIVATE = "private";
    private static final String ALIYUN = "aliyun";

    public static ImageStore imageStore(String storeType) {
        switch (storeType) {
            case PRIVATE:
                return new PrivateImageStore();
            case ALIYUN:
                return new AliyunImageStore();
            default:
                throw new IllegalArgumentException("not impl yet");
        }
    }
}
