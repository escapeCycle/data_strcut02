package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 糖果交换
 * A数组和B数组中任意两个数字交换，保证A数组和B数组里面所有元素之和相等
 * 假设A中x和B中y交换 最后两组数总和相等
 * 则 sum(A) -x+y = sum(B) -y+x
 * y = (sum(B)-sum(A))/2 +x
 * @author tianhuan
 * @date 2019-03-24 16:40
 **/
public class LeetCode_888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        HashSet<Object> set = new HashSet<>();
        for(int i:A){
            sumA+=i;
        }
        int sumB = 0;
        for(int j:B){
            sumB+=j;
            set.add(j);
        }
        for(int x:A){
            if(set.contains((sumB-sumA)/2 + x)){
                return new int[]{x,(sumB-sumA)/2 + x};
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] A = {1,2,5},B = {2,4};
        int[] resInt = new LeetCode_888().fairCandySwap(A, B);
        Arrays.stream(resInt).forEach(System.out::println);
    }
}
