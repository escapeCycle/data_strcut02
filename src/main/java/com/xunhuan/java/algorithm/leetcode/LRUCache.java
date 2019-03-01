package com.xunhuan.java.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * lru
 * @author tianhuan
 * @date 2019-01-11 15:33
 **/
public class LRUCache {

    private HashMap<Integer,Integer> cacheMap = new HashMap<>();
    private LinkedList<Integer> recentlyList = new LinkedList<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key){
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        recentlyList.remove((Integer) key); // 必须使用非int类型，否则会调用按索引删除方法
        recentlyList.add(key);
        return cacheMap.get(key);
    }

    public void put(int key,int value){
        if(cacheMap.containsKey(key)){
            recentlyList.remove((Integer)key);
        }else if(cacheMap.size() == capacity){
            cacheMap.remove(recentlyList.removeFirst());
        }
        recentlyList.add(key);
        cacheMap.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);

        System.out.println(lruCache.get(1));

        lruCache.put(4,4);
        lruCache.put(1,1);

        System.out.println(lruCache.get(2));
    }
}
