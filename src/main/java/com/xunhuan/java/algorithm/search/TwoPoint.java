package com.xunhuan.java.algorithm.search;

/**
 * 二分法查找(只能查找有序结构)
 *
 * @author tianhuan
 * @date 2018-11-23 12:20
 **/
public class TwoPoint {

    /**
     * while
     *
     * @param arr    查找的数组
     * @param target 查找的元素
     * @return 返回元素位置 -1 没有此元素
     */
    public int search(int[] arr, int target) {
        /*
            起始位置
         */
        int begin = 0;
        /*
            结束位置
         */
        int end = arr.length - 1;
        /*
            记录目标位置
         */
        int index;

        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }

            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     *
     * @param arr
     * @param length
     * @param target
     * @return
     */
    public int bsearch(int[] arr, int length, int target) {
        return bsearchInstall(arr, 0, length - 1, target);
    }

    private int bsearchInstall(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return bsearchInstall(arr, mid + 1, high, target);
        } else {
            return bsearchInstall(arr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        TwoPoint t = new TwoPoint();
        int search = t.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 6);
//        int search = t.search(new int[]{8,7,6,5,4,3,2,1}, 2);
        System.out.println(search);
//


        int search2 = t.bsearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 100, 201}, 10, 100);
        System.out.println(search2);
        System.out.println(5 % 3);
        System.out.println(8 / 3);
        System.out.println(Math.floorMod(5, -3));

        System.out.println(300_000);
    }

}
