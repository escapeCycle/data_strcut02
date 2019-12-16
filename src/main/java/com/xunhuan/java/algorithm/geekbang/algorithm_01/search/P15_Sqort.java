package com.xunhuan.java.algorithm.geekbang.algorithm_01.search;

/**
 * 用二分法求一个数的平方根，精确到小数点后6位
 */
public class P15_Sqort {

    public static double sqrt(double x, double precision) {
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double up = x;
        if (x < 1 && x > 0) {
            /**小于1的时候*/
            low = x;
            up = 1;
        }
        double mid = low + (up - low) / 2;
        while (up - low > precision) {
            if (mid * mid > x) {//TODO mid可能会溢出
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
            mid = low + (up - low) / 2;
        }
        return mid;
    }

    /**
     * 求一个数的平方根
     *
     * @param x
     * @param precision 小数点后精度
     * @return
     */
    public static double sqrt2(double x, double precision) {
        if (x == 0) return 0;
        if (x < 0) return Double.NaN;
        double max = x;
        double min = 0;
        if (x < 1 && x > 0) {
            min = x;
            max = 1;
        }

        double c = 1 / (Math.pow(10, precision));

        while (min <= max) {
            double i = (new Double(max * Math.pow(10, precision)).intValue()
                    - new Double(min * Math.pow(10, precision)).intValue())
                    / 2 / Math.pow(10, precision);
            double mid = min + i;
            if ((mid + c) * (mid + c) > x && (mid - c) * (mid - c) < x) {
                return mid;
            } else if (mid * mid > x) {
                max = mid - c;
            } else {
                min = mid + c;
            }
        }

        return Double.NaN;

    }


    public static void main(String[] args) {
        double sqrt = P15_Sqort.sqrt2(1909, 6);
        System.out.println(sqrt);

        double res = Math.sqrt(1909);
        System.out.println(res);
    }
}
