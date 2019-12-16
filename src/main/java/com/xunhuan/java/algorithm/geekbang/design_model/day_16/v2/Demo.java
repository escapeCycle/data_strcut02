package com.xunhuan.java.algorithm.geekbang.design_model.day_16.v2;

/**
 * 如果增加一种check的话，只需要加一个类,类似{@link TpsAlertHandler} ,并且在{@link ApplicationContext} 的初始化中增加handler即可
 * 调用方，无需变动
 */
public class Demo {

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // 设置属性

        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
