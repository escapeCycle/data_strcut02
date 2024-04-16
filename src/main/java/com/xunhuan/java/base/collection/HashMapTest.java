package com.xunhuan.java.base.collection;

import com.xunhuan.java.structure.tree.Node;

import java.util.*;

/**
 * @author tianh
 * @description:
 * @date 2021-03-19 14:14
 */
public class HashMapTest {


    public static void main(String[] args) {
        Object o = new Object();
        //System.out.println(o.hashCode());
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();
        Person person8 = new Person();
        Person person9 = new Person();
        Person person10 = new Person();
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());
        System.out.println(person4.hashCode());
        System.out.println(person5.hashCode());
        System.out.println(person6.hashCode());
        System.out.println(person7.hashCode());
        System.out.println(person8.hashCode());
        System.out.println(person9.hashCode());
        System.out.println(person10.hashCode());

        System.out.println((person1.hashCode() ^ person1.hashCode() >>> 16) & 15);
        System.out.println((person2.hashCode() ^ person2.hashCode() >>> 16) & 15);
        System.out.println((person3.hashCode() ^ person3.hashCode() >>> 16) & 15);
        System.out.println((person4.hashCode() ^ person4.hashCode() >>> 16) & 15);
        System.out.println((person5.hashCode() ^ person5.hashCode() >>> 16) & 15);
        System.out.println((person6.hashCode() ^ person6.hashCode() >>> 16) & 15);
        System.out.println((person7.hashCode() ^ person7.hashCode() >>> 16) & 15);
        System.out.println((person8.hashCode() ^ person8.hashCode() >>> 16) & 15);
        System.out.println((person9.hashCode() ^ person9.hashCode() >>> 16) & 15);
        System.out.println((person10.hashCode() ^ person10.hashCode() >>> 16) & 15);


        //System.out.println(3 >>> 1);
        //
        HashMap<Person, String> map = new HashMap<>();
        map.put(person1, "a");
        map.put(person2, "b");
        map.put(person3, "c");
        map.put(person4, "d");
        map.put(person5, "e");
        map.put(person6, "f");
        map.put(person7, "g");
        map.put(person8, "h");
        map.put(person9, "i");
        map.put(person10, "j");
        //
        //String a = "1";
        //String b = "2";
        //String c = "3";
        //System.out.println(a.hashCode() + "\n" + b.hashCode() + "\n" + c.hashCode());
        // 第三个参数用于指定accessOrder值
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, false);
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        System.out.println("开始时顺序：");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");
        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}

class Person {
    private String name;
}