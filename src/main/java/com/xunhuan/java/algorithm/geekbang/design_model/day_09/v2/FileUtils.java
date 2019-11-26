package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class FileUtils {

    public static Properties load(String path) {
        Properties properties = null;
        try (InputStream in = new FileInputStream(Paths.get(path).toFile())) {
            properties = new Properties();
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
