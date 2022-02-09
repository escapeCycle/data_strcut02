package com.xunhuan.java.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author tianh
 * @description:
 * @date 2022/1/27 4:14 下午
 */
public class FileReadTest2 {


    public static void main(String[] args) {
        try{

            FileReader fr = new FileReader("src/main/resources/textEdit");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                if(str.contains("\"idNumber\"") && !str.contains("*")){
                    System.out.println(str.trim());
                }
            }
            bf.close();
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
