package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 山脉数组,返回最大的峰值
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 *
 * @author tianhuan
 * @date 2019-03-12 14:59
 **/
public class LeetCode_852 {

    public int peakIndexInMountainArray(int[] A) {

        for (int i = 1; i < A.length - 1; i++) {
            if(A[i] > A[i-1] && A[i] > A[i+1]){

                return i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] A){
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }

    /**
     * 二分查找
     * @param A
     * @return
     */
    public int peakIndexInMountainArray3(int[] A){
        int start = 0,end = A.length;

        while (start < end){
            int mid = start + (end - start)/2;
            if(A[mid] < A[mid+1]){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] A = new int[]{0,2,1,0};
        int i = new LeetCode_852().peakIndexInMountainArray3(A);
        System.out.println(i);
    }

}
