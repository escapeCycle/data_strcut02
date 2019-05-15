package com.xunhuan.java.designmodel.singleton;

/**
 * @author tianhuan
 * @date 2019-04-19 18:59
 **/
public enum SingletonEnum {

    /**
     * 实例化
     */
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        // 单例测试
        SingletonEnum firstSingleton = SingletonEnum.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());

        SingletonEnum secondSingleton = SingletonEnum.INSTANCE;
        secondSingleton.setObjName("secondName");

        System.out.println(firstSingleton.getObjName());

        System.out.println(secondSingleton.getObjName());


        // 反射获取实例测试
        try {
            SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
            for (SingletonEnum enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
