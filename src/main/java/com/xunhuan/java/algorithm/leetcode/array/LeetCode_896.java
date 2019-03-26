package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 判断一个数组是否是单调递增或者单调递减
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 *
 * @author tianhuan
 * @date 2019-03-25 18:10
 **/
public class LeetCode_896 {

    public boolean isMonotonic(int[] A) {
        int numsL = 1,numsR = 1;
        for (int i = 1; i < A.length; ++i) {
            if(A[i-1] <= A[i]){
                numsL++;
            }
            if(A[i-1] >= A[i]){
                numsR++;
            }
        }
        return (numsL == A.length) || (numsR == A.length);

    }

    public static void main(String[] args) {
        int[] arrs = {1, 2, 2, 3};
        boolean res = new LeetCode_896().isMonotonic(arrs);
        System.out.println(res);
    }
}
