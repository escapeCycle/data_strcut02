//package com.xunhuan.java.utils;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class ImageUtils {
//
//    public static void main(String[] args) {
//        ImageUtils.NetImageToBase64("https://www.baidu.com/img/bd_logo1.png");
//
//        try {
//            ImageUtils.GenerateImage(ImageUtils.NetImageToBase64("https://www.baidu.com/img/bd_logo1.png"),System.getProperty("user.dir")+"/keyFile/baidu.aa");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String NetImageToBase64(String netImagePath) {
//        final ByteArrayOutputStream data = new ByteArrayOutputStream();
//        String strNetImageToBase64 = null;
//        try {
//            // 创建URL
//            URL url = new URL(netImagePath);
//            final byte[] by = new byte[1024];
//            // 创建链接
//            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5000);
//
//            InputStream is = conn.getInputStream();
//            // 将内容读取内存中
//            int len = -1;
//            while ((len = is.read(by)) != -1) {
//                data.write(by, 0, len);
//            }
//            // 对字节数组Base64编码
//            BASE64Encoder encoder = new BASE64Encoder();
//            strNetImageToBase64 = encoder.encode(data.toByteArray());
//            System.out.println("网络图片转换Base64:" + strNetImageToBase64);
//            // 关闭流
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return strNetImageToBase64;
//    }
//
//    public static boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
//        if (imgData == null) // 图像数据为空
//            return false;
//        BASE64Decoder decoder = new BASE64Decoder();
//        OutputStream out = null;
//        try {
//            out = new FileOutputStream(imgFilePath);
//            // Base64解码
//            byte[] b = decoder.decodeBuffer(imgData);
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {// 调整异常数据
//                    b[i] += 256;
//                }
//            }
//            out.write(b);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            out.flush();
//            out.close();
//            return true;
//        }
//    }
//}
