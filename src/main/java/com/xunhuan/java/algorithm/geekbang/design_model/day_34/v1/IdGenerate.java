package com.xunhuan.java.algorithm.geekbang.design_model.day_34.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * id生成器
 */
public class IdGenerate {

    public static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static String hostName = "";
    private static final char[] CHAR_SET = BASE62.toCharArray();

    static {
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            String[] token = hostName.split("\\.");
            hostName = token[token.length - 1];
        } catch (UnknownHostException e) {
            hostName = "Unknown";
        }
    }

    /**
     * 随机生成可变长度字符串
     * @param length
     * @return
     */
    public String generateRandomStr(int length){
        char[] randomChars = new char[length];

        Random random = new Random();

        for(int i = 0;i<randomChars.length;i++){
            int raIndex = random.nextInt(BASE62.length());
            randomChars[i] = CHAR_SET[raIndex];
        }

        return new String(randomChars);
    }

    public String generateId(){
        String id;
        id = String.format("%s-%d-%s",hostName,System.currentTimeMillis(),generateRandomStr(8));
        return id;
    }


    public static void main(String[] args) {
        IdGenerate idGenerate = new IdGenerate();
        String id = idGenerate.generateId();
        System.out.println(id);
    }
}
