package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author tianhuan
 * @date 2018-11-28 16:27
 **/
public class ChoiceSort {

    public void sort(int[] arrs){
        if(arrs == null || arrs.length <= 1){
            return;
        }
        for(int i = 0;i<arrs.length;i++){
            int minIndex = i;

            for(int j = i+1;j<arrs.length;j++){
                if(arrs[j] < arrs[minIndex]){
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = arrs[i];
                arrs[i] = arrs[minIndex];
                arrs[minIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{66, 22, 55, 111, 29, 56, 99, 22};

        ChoiceSort sort = new ChoiceSort();
        sort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
