package com.xunhuan.java.structure.queue;

/**
 * @author tianhuan
 * @date 2018-11-23 15:46
 **/
public class MyQueue {

    private Object[] elements;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyQueue(){
        elements = new Object[0];
    }

    public MyQueue(int initialCapacity){
        if(initialCapacity > 0){
            elements = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            elements = EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

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

    public Object poll(){
        Object element = elements[0];
        Object[] newArr = new Object[elements.length-1];
        for(int i = 0;i<newArr.length;i++){
            newArr[i] = elements[i+1];
        }
        elements = newArr;
        return element;
    }

    public boolean isEmpty(){
        return elements.length == 0;
    }
}
