package com.xunhuan.java.algorithm.sword_offer;

/**
 * 将一个字符串中的空格替换成 "%20"。
 * Input:
 * "A B"
 * Output:
 * "A%20B"
 *
 * @author tianhuan
 * @date 2019-04-19 15:02
 **/
public class Sword_5 {

    public String replaceSpace(StringBuffer str) {
        int L1 = str.length() - 1;

        /**
         * 遇到一个空格就在字符串最后加两个空格
         */
        for (int i = 0; i < L1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int L2 = str.length() - 1;
        while (L1 >= 0 && L2 > L1) {
            char c = str.charAt(L1--);
            if (c == ' ') {
                str.setCharAt(L2--, '0');
                str.setCharAt(L2--, '2');
                str.setCharAt(L2--, '%');
            } else {
                str.setCharAt(L2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("A B C   ");
        Sword_5 sword_5 = new Sword_5();
        String s = sword_5.replaceSpace(buffer);
        System.out.println(s);
    }
}
