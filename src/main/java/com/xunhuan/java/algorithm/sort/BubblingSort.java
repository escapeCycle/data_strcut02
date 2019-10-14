package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author tianhuan
 * @date 2018-11-26 17:25
 **/
public class BubblingSort {

    public static final int[] elements = new int[]{99, 22, 55, 88, 29, 56, 99, 22};

    /**
     * 99, 22, 55, 88, 29, 56, 99, 22
     * 22, 99, 55, 88, 29, 56, 99, 22
     * 22, 55, 99, 88, 29, 56, 99, 22
     * 22, 55, 88, 99, 29, 56, 99, 22
     * 22, 55, 88, 29, 99, 56, 99, 22
     * 22, 55, 88, 29, 56, 99, 99, 22
     * 22, 55, 88, 29, 56, 99, 99, 22
     * 22, 55, 88, 29, 56, 99, 22, 99
     *
     *
     * @param elements
     * @return
     */
    public void sort(int[] elements){

        for (int i = 0; i < elements.length - 1; i++) {
            boolean flag = false; // 数据是否有交换标志
            /*
                比较次数
             */
            for (int j = 0; j < elements.length - 1 - i; j++) {

                if(elements[j] > elements[j+1]){
//                    int temp = elements[j];
//                    elements[j] = elements[j+1];
//                    elements[j+1] = temp;
                    int temp = elements[j+1];
                    elements[j+1] = elements[j];
                    elements[j] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break; //没有数据交换，在本次循环就直接退出
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{125, 22, 55, 111, 29, 56, 99, 22};
        BubblingSort sort = new BubblingSort();
        sort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }





}
