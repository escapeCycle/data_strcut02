package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 桶排序
 * @author tianhuan
 * @date 2019-03-18 16:56
 **/
public class BucketSort {


    public static void bucketSort(int[] arrs) {
        if (arrs == null || arrs.length < 2) {
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrs.length; i++) {
            max = Math.max(max, arrs[i]);
        }

        int[] bucket = new int[max+1];

        for(int i = 0;i<arrs.length;i++){
            //桶数组此下标有数据，数值就加一
            bucket[arrs[i]]++;
        }
        int i = 0;
        for (int j = 0;j<bucket.length;j++){
            while (bucket[j]-->0){
                arrs[i++]=j;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{66, 22, 55, 111, 29, 56, 99, 22};
        bucketSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
