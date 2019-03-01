package com.xunhuan.java.algorithm.leetcode;

/**
 * 奇数在前,偶数在后
 *
 * @author tianhuan
 * @date 2019-02-25 14:15
 **/
public class OddAndEvenSeparate {

    public static void main(String[] args) {
        int[] arrs = new int[]{4, 6, 5, 3, 2, 9};

        oddEvenSwap2(arrs);


        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i] + " ");
        }

    }

    public static void oddEvenSwap2(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] % 2 == 1 && i != 0) {
                for (int j = i; j > 0; j--) {
                    if(arrs[j-1] % 2 == 0){
                        int tempp = arrs[j-1];
                        arrs[j-1] = arrs[j];
                        arrs[j] = tempp;
                    }
                }
            }
        }

    }

    public static void oddEvenSwap(int[] arrs) {

        int start = 0;
        int end = arrs.length - 1;

        while (start < end) {

            if (arrs[start] % 2 == 1 && arrs[end] % 2 == 1) {
                start++;
            }
            if (arrs[start] % 2 == 0 && arrs[end] % 2 == 0) {
                end--;
            }
            if (arrs[start] % 2 == 0 && arrs[end] % 2 == 1) {
                int temp = arrs[start];
                arrs[start] = arrs[end];
                arrs[end] = temp;
                start++;
                end--;
            }
            if (arrs[start] % 2 == 1 && arrs[end] % 2 == 0) {
                start++;
            }

        }

    }

    public static void reorderOddEven(int[] array) {
        if (array == null || array.length <= 0) {
            throw new RuntimeException("invalid array");
        }
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (begin < end && (array[begin] & 1) != 0) {
                begin++;
            }
            while (begin < end && (array[end] & 1) == 0) {
                end--;
            }
            if (begin < end) {
                int temp = array[end];
                array[end] = array[begin];
                array[begin] = temp;
            }
        }
    }

    public static void reOrderArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > 0; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void oddAddEven(int[] arrs) {

        for (int i = 0; i < arrs.length; i++) {
            for (int j = arrs.length - 1; j > 0; j--) {

                if (arrs[j - 1] % 2 == 0 && arrs[j] % 2 == 1) {
                    int temp = arrs[j - 1];
                    arrs[j - 1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }


}
