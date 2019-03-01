package com.xunhuan.java.structure.arrays;

import java.util.Arrays;

/**
 * @author tianhuan
 * @date 2018-11-22 16:37
 **/
public class ArraysTest {

    public static void main(String[] args) {

        /*
            定义一个数组
         */
        int a[] = new int[]{9,8,7,6,5,4};

        /*
            要删除的数组下标
         */
        int dst = 3;

        int[] newArray = new int[a.length-1];
//        Arrays.stream(newArray).map();

        for(int i = 0;i<newArray.length; i++){
            if(i<dst){
                newArray[i] = a[i];
            }else{
                newArray[i] = a[i+1];
            }
        }
        Arrays.stream(newArray).forEach(System.out::println);

    }
}
