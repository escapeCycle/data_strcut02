package com.xunhuan.java.algorithm.search;

/**
 * 二分法查找(只能查找有序结构)
 * @author tianhuan
 * @date 2018-11-23 12:20
 **/
public class TwoPoint {

    /**
     *
     * @param arr 查找的数组
     * @param target 查找的元素
     * @return 返回元素位置 -1 没有此元素
     */
    public int search(int[] arr,int target){
        /*
            起始位置
         */
        int begin = 0;
        /*
            结束位置
         */
        int end = arr.length - 1;
        /*
            中间位置
         */
        int mid = (begin + end)/2;
        /*
            记录目标位置
         */
        int index;

        while (true){
            if(begin >= end){
                return -1;
            }
            if(arr[mid] == target){
                index = mid;
                break;
            }else{
                if(arr[mid] > target){
                    end = mid - 1;
                }else{
                    begin = mid +1;
                }
                mid = (begin+end)/2;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TwoPoint t = new TwoPoint();
//        int search = t.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 9);
        int search = t.search(new int[]{8,7,6,5,4,3,2,1}, 2);
        System.out.println(search);
//
        System.out.println(5 % 3);
        System.out.println(8/3);
        System.out.println(Math.floorMod(5, -3));

        System.out.println(300_000);
    }

}
