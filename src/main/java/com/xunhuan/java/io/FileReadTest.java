package com.xunhuan.java.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author tianhuan
 * @date 2019-03-21 14:35
 **/
public class FileReadTest {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("d://songsJSON.txt");
        byte[] a = new byte[1024];
        int length = 0;
        while ((length = fileInputStream.read(a)) != -1) {
            System.out.print(new String(a, 0, length,"GBK"));
        }
        fileInputStream.close();

        StringBuffer c = new StringBuffer();
        String replace = c.toString().replace(" ", "%20");

    }

}
