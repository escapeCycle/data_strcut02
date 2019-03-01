package com.xunhuan.java.structure.stack;

import java.util.Arrays;

/**
 * @author tianhuan
 * @date 2018-11-23 15:23
 **/
public class MyStack {

    private Object[] elements;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public MyStack(){
       elements = new Object[0];
    }

    public MyStack(int initialCapacity){
        if(initialCapacity > 0){
            elements = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            elements = EMPTY_ELEMENTDATA;
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public void push(Object o){
        Object[] newStack = new Object[elements.length+1];

        for(int i = 0;i<elements.length;i++){
            newStack[i] = elements[i];
        }
        newStack[elements.length] = o;
        elements = newStack;
    }

    public Object pop(){
        if(elements.length == 0){
            throw new RuntimeException("stack is empty");
        }
        Object element = elements[elements.length - 1];
        Object[] newStack = new Object[elements.length-1];
        for(int i = 0;i<elements.length - 1;i++){
            newStack[i] = elements[i];
        }
        elements = newStack;
        return element;
    }

    public boolean isEmpty(){
        return elements.length == 0;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public Object peek(){
        return elements[elements.length - 1];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Arrays.stream(stack.elements).forEach(System.out::println);

        System.out.println(stack.pop());
        Arrays.stream(stack.elements).forEach(System.out::println);
    }

}
