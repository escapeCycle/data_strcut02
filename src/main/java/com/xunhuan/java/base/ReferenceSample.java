package com.xunhuan.java.base;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author tianhuan
 * @date 2019-04-25 18:03
 **/
public class ReferenceSample {

    public static void main(String[] args) {
        /**
         * 强引用
         * 被强引用关联的对象不会被回收。
         */
        Object obj1 = new Object();

        /**
         * 软引用
         * 被软引用关联的对象只有在内存不够的情况下才会被回收
         */
        Object obj2 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj2);
        obj2 = null;  // 使对象只被软引用关联

        /**
         * 弱引用
         * 被弱引用关联的对象一定会被回收，也就是说它只能存活到下一次垃圾回收发生之前
         */
        Object obj3 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj3);
        obj3 = null;  //使对象只被弱引用关联

        /**
         * 虚引用
         * 又称为幽灵引用或者幻影引用，一个对象是否有虚引用的存在，
         * 不会对其生存时间造成影响，也无法通过虚引用得到一个对象。
         *
         * 为一个对象设置虚引用的唯一目的是能在这个对象被回收时收到一个系统通知。
         */
        Object obj4 = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj4, null);
        obj4 = null;  //使对象只被虚引用关联
    }
}
