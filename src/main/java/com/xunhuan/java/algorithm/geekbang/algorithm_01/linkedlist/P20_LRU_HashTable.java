package com.xunhuan.java.algorithm.geekbang.algorithm_01.linkedlist;

import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * 散列表+双向链表 实现LRU
 */
public class P20_LRU_HashTable<K, V> {


    private DNode<K, V> head;
    private DNode<K, V> tail;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    private HashMap<K, DNode<K, V>> table;

    public P20_LRU_HashTable(Integer capacity) {
        this.head = new DNode<>();
        this.tail = new DNode<>();
        this.length = 0;

        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.table = new HashMap<>();
    }

    public void add(K key, V value) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            DNode<K, V> newNode = new DNode<>(key, value);

            addNode(newNode);
            table.put(key, newNode);
            if (++length > capacity) {
                /**
                 * 超出容量将尾部节点删除
                 */
                DNode<K, V> tailNode = popTail();
                table.remove(tailNode.key);
                length--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 向头节点插入一个数据
     *
     * @param newNode
     */
    private void addNode(DNode<K, V> newNode) {
        newNode.next = head.next;
        newNode.pre = head;

        head.next.pre = newNode;
        head.next = newNode;
    }

    /**
     * 弹出尾部节点
     *
     * @return
     */
    private DNode<K, V> popTail() {
        DNode<K, V> tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }

    /**
     * 移除节点
     *
     * @param node
     */
    private void removeNode(DNode<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 移动到队列头部
     *
     * @param node
     */
    private void moveToHead(DNode<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 获取节点数据
     *
     * @param key
     * @return
     */
    public V get(K key) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 移除节点数据
     *
     * @param key
     */
    public void remove(K key) {
        DNode<K, V> removeNode = table.get(key);
        if (removeNode == null) {
            return;
        }

        removeNode(removeNode);
        length--;
        table.remove(removeNode.key);
    }

    private void printAll() {
        DNode<K, V> node = head.next;
        while (node.next != null) {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }

    @NoArgsConstructor
    private class DNode<K, V> {

        private K key;
        private V value;

        private DNode<K, V> pre;
        private DNode<K, V> next;

        DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        P20_LRU_HashTable p20 = new P20_LRU_HashTable(16);
        String key1 = "testOne";
        String value1 = "oneValue";
        String key2 = "testTwo";
        String value2 = "twoValue";
        String key3 = "testThree";
        String value3 = "threeValue";
        p20.add(key1, value1);
        p20.add(key2, value2);
        p20.add(key3, value3);


        p20.printAll();

        p20.remove(key1);

        p20.get(key2);


        p20.printAll();
    }
}
