package com.xunhuan.java.algorithm.sort;

import com.xunhuan.java.structure.queue.MyQueue;

import java.util.Arrays;

/**
 * 队列实现_基数排序
 *
 * @author tianhuan
 * @date 2018-12-03 14:20
 **/
public class RadixSortWithQueue {

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
        System.out.println("最大数为:" + max);
        /*
            计算最大数字是几位数
         */
        int maxLength = (max + "").length();
        /*
            用于临时存储数据的队列
         */
        MyQueue[] temp = new MyQueue[10];
        /*
            为每个队列赋值
         */
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new MyQueue();
        }
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
                    把当前遍历的数据放入指定的队列中
                 */
                temp[ys].add(arrs[j]);
            }
            int index = 0;
            /*
                把数字取出来
             */
            for (int k = 0; k < temp.length; k++) {
                    /*
                        循环取出元素
                     */
                while (!temp[k].isEmpty()) {
                    arrs[index] = (int) temp[k].poll();
                    /*
                       记录下一个位置
                    */
                    index++;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{125, 22, 55, 111, 29, 56, 99, 22};
        RadixSortWithQueue sort = new RadixSortWithQueue();
        sort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
