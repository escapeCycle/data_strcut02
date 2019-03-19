package com.xunhuan.java.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 使用LinkedHashMap实现LRU
 *
 * @author tianhuan
 * @date 2019-03-01 11:24
 **/
public class LRUCache2<K, V> {
    private final int MAX_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;

    private LinkedHashMap<K, V> map;

    public LRUCache2(int cacheSize) {
        this.MAX_SIZE = cacheSize;
        int capacity = (int) Math.ceil(MAX_SIZE / DEFAULT_LOAD_FACTORY) + 1;

        /**
         *
         * 第三个参数设置为true，代表linkedlist按访问顺序排序，可作为LRU缓存
         * 第三个参数设置为false，代表按插入顺序排序，可作为FIFO缓存
         */
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_SIZE;
            }
        };
    }

    /**
     * 非线程安全，加锁
     *
     * @param key
     * @param value
     */
    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key){
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K,V>> getAll(){
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<K,V> kvEntry :map.entrySet()){
            stringBuilder.append(String.format("%s : %s  %s",kvEntry.getKey(),kvEntry.getValue(),"\n"));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LRUCache2<Integer, Integer> lruCache = new LRUCache2<>(5);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);

        lruCache.get(1);
        lruCache.get(2);

        System.out.println(lruCache.toString());
    }

}
