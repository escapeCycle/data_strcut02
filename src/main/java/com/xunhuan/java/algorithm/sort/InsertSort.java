package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author tianhuan
 * @date 2018-11-27 15:14
 **/
public class InsertSort {

    /**
     * 普通的插入排序
     * @param arrs
     */
    public void sort(int[] arrs){
        if(arrs == null || arrs.length <= 1){
            return;
        }
        for (int i = 1; i < arrs.length; i++) {
            if(arrs[i] < arrs[i-1]){
                int temp = arrs[i];
                int j;
                /*
                    遍历当前数字前面的数字
                 */
                for (j = i - 1; j >= 0 && temp < arrs[j]; j--) {
                    arrs[j + 1] = arrs[j];
                }
                arrs[j + 1] = temp;
            }
        }
    }

    public void sort2(int[] arrs){
        if(arrs == null || arrs.length <= 1){
            return;
        }
        for (int i = 1; i < arrs.length; i++) {
            if(arrs[i] < arrs[i-1]){
                int temp = arrs[i];
                int j;
                /*
                    遍历当前数字前面的数字
                 */
                for (j = i - 1; j >= 0; j--) {
                    if(temp <arrs[j]){
                        arrs[j + 1] = arrs[j];
                    }else{
                        break;
                    }

                }
                arrs[j + 1] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * @param arrs
     */
    public void shellSort(int[] arrs) {
        /*
            遍历所有步长
         */
        for (int step = arrs.length / 2; step > 0; step /= 2) {
            /*
                遍历所有元素
             */
            for (int i = step; i < arrs.length; i++) {

                for (int j = i - step; j >= 0; j -= step) {

                    if (arrs[j] > arrs[j + step]) {
                        int temp = arrs[j];
                        arrs[j] = arrs[j + step];
                        arrs[j + step] = temp;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{66, 22, 55, 111, 29, 56, 99, 22};
        InsertSort sort = new InsertSort();
//        sort.sort(arr);
//
//        Arrays.stream(arr).forEach(System.out::println);

        sort.shellSort(arr);

        Arrays.stream(arr).forEach(System.out::println);

    }

}
