package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v3;

import com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2.FileUtils;
import com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2.ImageStore;

import java.awt.*;

/**
 * 利用反射
 */
public class ImageProcessingJob {

    private static final String BUCKET_NAME = "ai_images_bucket";
    private static final String STORE_CLASS = "STORE_CLASS";
    private static final String PROP_PATH = "src/main/java/com/xunhuan/java/algorithm/geekbang/design_model/day_09/v3/comfig.properties";

    public void process() {
        Image image = null;
        try {
            String storeClass = FileUtils.load(PROP_PATH)
                    .getProperty(STORE_CLASS);
            ImageStore imageStore = (ImageStore) Class.forName(storeClass).newInstance();
            imageStore.upload(image, BUCKET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ImageProcessingJob job = new ImageProcessingJob();
        job.process();
    }
}
