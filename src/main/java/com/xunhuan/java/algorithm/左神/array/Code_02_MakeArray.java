package com.xunhuan.java.algorithm.左神.array;

/**
 * @author tianh
 * @description: 题目 ： 输入一个int类型的N，构造一个长度为N的数组arr并返回，
 * 要求 :  对任意的 i<k<j ,都满足 arr[i] + arr[j] != 2 * arr[j]
 * 此题需考虑 奇数 + 偶数 = 奇数( != 偶数) 问题  , 且 2 * arr[i] + 2 * arr[j] != 2 * 2 * arr[j] , 且 (2 * arr[i] + 1） + (2 * arr[j] + 1) != 2 * (2 * arr[j] + 1)
 * @date 2022/8/2 17:26
 */
public class Code_02_MakeArray {

    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[]{1};
        }

        int half = (size + 1) / 2;
        int[] base = makeNo(half);
        int index = 0;
        int[] res = new int[size];
        for (; index < half; index++) {
            res[index] = 2 * base[index] + 1;
        }
        for (int i = 0; index < size; index++, i++) {
            res[index] = 2 * base[i];
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
