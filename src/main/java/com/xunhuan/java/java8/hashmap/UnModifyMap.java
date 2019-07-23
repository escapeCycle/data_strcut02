package com.xunhuan.java.java8.hashmap;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class UnModifyMap {


    public static Map<String,String> getUnModifyMap(Map<String,String> map){
        return Collections.unmodifiableMap(map);
    }


    public static void main(String[] args) {
        Map<String, String> oriMap = new HashMap<>();

        oriMap.put("keyOne","1");
        oriMap.put("keyTwo","2");
        oriMap.put("keyThree","3");

        Map<String, String> unModifyMap = getUnModifyMap(oriMap);

        unModifyMap.put("keyFour","4");
    }
}
