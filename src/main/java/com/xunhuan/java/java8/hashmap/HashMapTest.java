package com.xunhuan.java.java8.hashmap;

import java.util.HashMap;

/**
 * @author tianhuan
 * @date 2019-02-19 18:56
 **/
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Key, Integer> hashMap = new HashMap<>();

        hashMap.put(new Key(1),2);
        hashMap.put(new Key(1),2);
        hashMap.put(new Key(3),2);
        hashMap.put(new Key(4),2);

        System.out.println(hashMap.size());
    }
}
