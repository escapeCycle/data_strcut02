package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author tianhuan
 * @date 2018-12-03 14:20
 **/
public class RadixSort {

    public void sort(int[] arrs) {
        /*
            排序多少轮 取决于最大数的长度
         */
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] > max) {
                max = arrs[i];
            }
        }
        System.out.println("最大数为:"+max);
        /*
            计算最大数字是几位数
         */
        int maxLength = (max + "").length();
        /*
            用于临时存储数据的数组
         */
        int[][] temp = new int[10][arrs.length];
        /*
            用于记录在temp中相应的数组中存放的数字的数量
         */
        int[] counts = new int[10];
        /*
            根据最大长度决定比较次数
         */
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arrs.length; j++) {
                /*
                    计算余数
                 */
                int ys = arrs[j] / n % 10;
                /*
                    把当前遍历的数据放入指定的数组中
                 */
                temp[ys][counts[ys]] = arrs[j];
                /*
                    记录数量
                 */
                counts[ys]++;
            }
//            if(i == 0){
//                for(int[] nums:temp){
//                    System.out.println(Arrays.toString(nums));
//                }
//                System.out.println(Arrays.toString(counts));
//            }

            int index = 0;
            /*
                把数字取出来
             */
            for (int k = 0; k < counts.length; k++) {
                if (counts[k] != 0) {
                    /*
                        循环取出元素
                     */
                    for (int l = 0; l < counts[k]; l++) {
                        arrs[index] = temp[k][l];
                        /*
                            记录下一个位置
                         */
                        index++;
                    }
                }
                /*
                    把数量置为0
                 */
                counts[k] = 0;
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{125, 22, 55, 111, 29, 56, 99, 22};
        RadixSort sort = new RadixSort();
        sort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
