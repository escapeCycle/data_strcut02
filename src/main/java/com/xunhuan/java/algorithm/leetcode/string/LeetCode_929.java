package com.xunhuan.java.algorithm.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入：["test.email+alex@leetcode.com",
 * "test.e.mail+bob.cathy@leetcode.com",
 * "testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 *
 * @author tianhuan
 * @date 2019-03-01 14:13
 **/
public class LeetCode_929 {
    public int numUniqueEmails(String[] emails) {
        HashMap<Object, Object> map = new HashMap<>(64);
        for (int i = 0; i < emails.length; i++) {
            String preStr = emails[i];
            preStr = preStr.substring(0, preStr.indexOf("@"));
            if (preStr.indexOf("+") > 0) {
                preStr = preStr.substring(0, preStr.indexOf("+"));
            }
            preStr = preStr.replace(".", "");
            preStr = preStr + emails[i].substring(emails[i].indexOf("@"), emails[i].length());
            map.put(preStr, preStr);
            System.out.println(preStr);
        }
        return map.size();
    }

    /**
     * 流和正则
     * @param emails
     * @return
     */
    public int numUniqueEmails2(String[] emails) {
        return  (int) Arrays.stream(emails).map(a1 -> {
            a1 = a1.replaceAll("\\+.*@", "@");
            while (a1.matches(".*\\..*@.*")) {
                a1 = a1.replaceFirst("\\.", "");
            }
            return a1;
        }).distinct().count();
    }

    public static void main(String[] args) {
        String str = "test.e.m+ail+alex@leetcode.com";
        System.out.println(str.indexOf("?"));
//        String substring = str.substring(0, str.indexOf("+"));
//        System.out.println(substring);
//        String s = substring.replace(".","");
//        System.out.println(s);

//        String sss = str.replaceAll("\\+.*@", "@");
//
//        while (sss.matches(".*\\..*@.*")) {
//            sss = sss.replaceFirst("\\.", "");
//        }
//        System.out.println(sss);

        String[] strs = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int num = new LeetCode_929().numUniqueEmails2(strs);
        System.out.println(num);
    }
}
