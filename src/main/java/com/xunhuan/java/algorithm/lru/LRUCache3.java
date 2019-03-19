package com.xunhuan.java.algorithm.lru;

/**
 * 直接使用双向链表存储数据并记录位置信息
 * @author tianhuan
 * @date 2019-03-01 12:05
 **/
public class LRUCache3<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private int capacity = 0;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
    }



    class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
