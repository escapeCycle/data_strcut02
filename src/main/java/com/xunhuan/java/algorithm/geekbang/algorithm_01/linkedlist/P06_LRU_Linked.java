package com.xunhuan.java.algorithm.geekbang.algorithm_01.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

/**
 * 单链表实现LRU
 */
public class P06_LRU_Linked<T> {

    /**
     * 默认容量
     */
    public static final int DEFAULT_CAPACITY = 10;

    private Node head; //空节点头，不存数据

    private Integer length;

    private Integer capacity; //容量


    public P06_LRU_Linked() {
        this.head = new Node();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public P06_LRU_Linked(Integer capacity) {
        this.head = new Node();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 添加一个元素
     *
     * @param data
     */
    public void add(T data) {
        Node preNode = findPreNode(data);

        /**
         * 如果元素存在
         */
        if (preNode != null) {
            deleteElementOpt(preNode); // 删除这个元素
            addAtHead(data); // 在头部添加这个元素
        } else {
            if (length >= capacity) {
                deleteEndElement(); // 元素已满则删除最后一个元素
            }
            addAtHead(data);
        }
    }


    /**
     * 查找一个元素
     *
     * @param data
     * @return
     */
    public Node find(T data) {
        Node preNode = findPreNode(data);

        if (preNode != null) {
            Node curNode = preNode.getNext();
            deleteElementOpt(preNode);
            addAtHead(data);
            return curNode;
        } else {
            return null;
        }
    }

    /**
     * 链表头部添加一个节点
     */
    public void addAtHead(T data) {
        Node next = head.getNext();
        head.setNext(new Node(data, next));
        length++;
    }


    public void deleteEndElement() {
        Node curNode = head;
        if (curNode.getNext() == null) {
            return;
        }
        /**
         * 需要遍历链表直到最后
         */
        while (curNode.getNext().getNext() != null) {
            curNode = curNode.getNext();
        }

        Node tmp = curNode.getNext();
        curNode.setNext(null);
        tmp = null;
        length--;
    }

    /**
     * 删除preNode的下一个元素
     *
     * @param preNode
     */
    public void deleteElementOpt(Node preNode) {
        Node tmp = preNode.getNext();
        preNode.setNext(tmp.getNext());
        tmp = null;
        length--;
    }

    /**
     * 查找元素的前一个节点
     *
     * @return
     */
    public Node findPreNode(T data) {
        Node curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getNext().getElement().equals(data)) {
                return curNode;
            }
            curNode = curNode.getNext();
        }
        return null;
    }

    private void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        P06_LRU_Linked list = new P06_LRU_Linked();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.find(5);
            list.printAll();
        }
    }

}

@Data
@AllArgsConstructor
class Node<T> {
    private T element;
    private Node next;

    public Node(T element) {
        this.element = element;
    }

    public Node() {
        this.element = null;
    }
}