package com.xunhuan.java.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * @author tianhuan
 * @date 2019-03-20 22:09
 **/
public class LeetCode_937 {

    public String[] reorderLogFiles(String[] logs) {
        List<String> numList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String[] split1 = logs[i].split(" ", 2);
            boolean digit = Character.isDigit(split1[1].charAt(0));
            if(digit){
                numList.add(logs[i]);
            }else{
                strList.add(logs[i]);
            }
        }
        strList.sort((str1,str2)->{
            String[] split1 = str1.split(" ", 2);
            String[] split2 = str2.split(" ", 2);
            return split1[1].compareTo(split2[1]);
        });
        strList.addAll(numList);
        String[] str = new String[strList.size()];
        strList.toArray(str);
        return str;
    }

    public static void main(String[] args) {

        String[] str = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] strings = new LeetCode_937().reorderLogFiles(str);
        System.out.println("---");
    }
}
