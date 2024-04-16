package com.xunhuan.java.algorithm.sword_offer;

/**
 * @author tianh
 * @description:
 * @date 2022/6/9 18:48
 */
public class Sword_5_02 {

    public String relaceSpace(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder stb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                stb.append("%20");
            } else {
                stb.append(c);
            }
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        Sword_5_02 sword_5_02 = new Sword_5_02();
        System.out.println(sword_5_02.relaceSpace("aab kj jh"));
    }
}
