package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  双重检测（
 *  网上有人说，这种实现方式有些问题。因为指令重排序，可能会导致 IdGenerator 对象被 new 出来，并且赋值给 instance 之后，还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。
 *  要解决这个问题，我们需要给 instance 成员变量加上 volatile 关键字，禁止指令重排序才行。实际上，只有很低版本的 Java 才会有这个问题。我们现在用的高版本的 Java 已经在 JDK 内部实现中解决了这个问题（解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序）。
 *  ）
 *
 *  Using localRef, we are reducing the access of volatile variable to just one for positive usecase.
 *  If we do not use localRef, then we would have to access volatile variable twice - once for checking null and then at method return time.
 *  Accessing volatile memory is quite an expensive affair because it involves reaching out to main memory.
 *
 *  相关地址
 *  https://www.javacodemonk.com/threadsafe-singleton-design-pattern-java-806ad7e6
 *
 * @author tianh
 * @description:
 * @date 2020-04-16 11:41
 */
public class IdGenerator3_1 {
    private AtomicInteger id = new AtomicInteger(0);
    public static volatile IdGenerator3_1 instance;
    private IdGenerator3_1(){}
    public static IdGenerator3_1 getInstance(){
        IdGenerator3_1 localRef = instance;  // 使用局部变量接收
        if(localRef == null){
            synchronized (IdGenerator3_1.class){ // 类级别锁
                localRef = instance;
                if(localRef == null){
                    instance = localRef = new IdGenerator3_1();
                }
            }
        }
        return instance;
    }
    public int getId(){
        return id.incrementAndGet();
    }
}
