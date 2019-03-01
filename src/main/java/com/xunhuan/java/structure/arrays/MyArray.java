package com.xunhuan.java.structure.arrays;

import lombok.val;

import java.util.Arrays;

/**
 * @author tianhuan
 * @date 2018-11-22 18:13
 **/
public class MyArray {

    private Object[] elements;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyArray(int initialCapacity){
        if(initialCapacity > 0){
            elements = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            elements = EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public int size(){
        return elements.length;
    }

    /**
     * 添加元素(在末尾)
     * @param o
     */
    public void add(Object o){
        /*
            定义新数组的长度(在原有基础上+1)
         */
        Object[] newArr = new Object[elements.length+1];
        /*
            拷贝原有数组(System.arraycopy)  Arrays.copyOf
         */
        for(int i = 0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
        newArr[elements.length] = o;
        elements = newArr;
    }

    /**
     * 插入元素到指定位置
     * @param index
     * @param o
     */
    public void insert(int index,Object o){
        /*
            创建一个新数组
         */
        Object[] newArr = new Object[elements.length+1];
        for(int i = 0;i<elements.length;i++){
            if(i < index){
                newArr[i] = elements[i];
            }else{
                newArr[i+1] = elements[i];
            }
        }
        newArr[index] = o;

        elements = newArr;
    }

    /**
     * 删除元素
     * @param index
     */
    public void delete(int index){
        val newArray = new Object[elements.length-1];
        for(int i = 0;i<newArray.length; i++){
            if(i<index){
                newArray[i] = elements[i];
            }else{
                newArray[i] = elements[i+1];
            }
        }
        elements = newArray;
    }

    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    public Object get(int index){
        return elements[index];
    }


    public static void main(String[] args) {
        MyArray a = new MyArray(0);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        Arrays.stream(a.elements).forEach(System.out::print);
        System.out.println();
        System.out.println(a.size());
        a.delete(1);
        Arrays.stream(a.elements).forEach(System.out::print);
    }
}
