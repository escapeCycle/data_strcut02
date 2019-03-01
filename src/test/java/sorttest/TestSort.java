package sorttest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author tianhuan
 * @date 2019-02-26 14:23
 **/
public class TestSort {

    @Test
    public void test() {
        int[] arrs = new int[]{2, 5, 2, 9, 5, 6};
        shellSort(arrs);
        Arrays.stream(arrs).forEach(System.out::println);
    }

    public void bubblingSort(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return;
        }
        /**
         *  遍历length - 1 次(比较)
         */
        for (int i = 0; i < arrs.length - 1; i++) {

            /**
             * 遍历length - 1 - i 次 (后面i个数已经排序好)
             */
            for (int j = 0; j < arrs.length - 1 - i; j++) {

                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                }

            }
        }
    }

    /**
     * 选择排序
     *
     * @param arrs
     */
    public void choiceSort(int[] arrs) {
        if (arrs == null || arrs.length <= 1) {
            return;
        }

        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;

            for (int j = arrs.length - 1; j > i; j--) {
                if (arrs[i] > arrs[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arrs[minIndex];
                arrs[minIndex] = arrs[i];
                arrs[i] = temp;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arrs
     */
    public void insertSort(int[] arrs) {
        if (arrs == null || arrs.length <= 1) {
            return;
        }
        for (int i = 1; i < arrs.length; i++) {
            int temp = arrs[i];
            int j;
            for (j = i - 1; j >= 0 && arrs[j] > temp; j--) {
                arrs[j + 1] = arrs[j];
            }
            arrs[j + 1] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param arrs
     */
    public void shellSort(int[] arrs) {
        if (arrs == null || arrs.length <= 1) {
            return;
        }

        for (int step = arrs.length / 2; step > 0; step /= 2) {

            for (int i = step; i < arrs.length; i++) {


                for (int j = i - step; j >= 0; j -= step) {
                    if (arrs[j] > arrs[j + step]) {
                        int temp = arrs[j];
                        arrs[j] = arrs[j + step];
                        arrs[j + step] = temp;
                    }
                }
            }
        }

    }
}
