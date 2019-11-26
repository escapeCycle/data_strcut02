package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2;

import java.awt.*;
import java.util.Properties;

public class ImageProcessingJob {

    private static final String BUCKET_NAME = "ai_images_bucket";
    private static final String STORE_TYPE = "STORE_TYPE";
    private static final String PROP_PATH = "src/main/java/com/xunhuan/java/algorithm/geekbang/design_model/day_09/v2/comfig.properties";
    ///Users/tianh/Documents/gitproject/myself/data_strcut02/src/main/java/com/xunhuan/java/algorithm/geekbang/design_model/day_09/v2/comfig.properties

    public void process(){
        Image image = null;
        String storeType = FileUtils.load(PROP_PATH).getProperty(STORE_TYPE);
        ImageStore imageStore = ImageStoreFactory.imageStore(storeType);
        imageStore.upload(image, BUCKET_NAME);
    }

    public static void main(String[] args) {

        ImageProcessingJob imageProcessingJob = new ImageProcessingJob();
        imageProcessingJob.process();
    }
}
