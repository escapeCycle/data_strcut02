package com.xunhuan.java.base.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author tianh
 * @description: 一致性hash ， KETAMA_HASH实现 增加虚拟节点
 * @date 2021/3/29 10:14 下午
 */
public class ConsistentHashVirtualNode {

    //服务器列表名称
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    //真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
    private static List<String> realList = new LinkedList<>();

    //虚拟节点
    private static SortedMap<Integer, String> vnMap = new TreeMap<>();

    //设置真实节点对应虚拟节点个数比例
    private static final int VIRTUAL_NODES = 5;

    //初始化真实节点列表和虚拟节点列表，构造hash环
    static {
        for (int i = 0; i < servers.length; i++) {
            realList.add(servers[i]);
        }

        for (String item : realList) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                //添加一个后缀作为虚拟节点名称
                String virtualNodeName = item + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                System.out.println("虚拟节点[" + virtualNodeName + "]被添加, hash值为" + hash);
                vnMap.put(hash, virtualNodeName);
            }
        }
    }

    private static String getServer(String str) {
        //求出hash值
        int hash = getHash(str);

        //获取大于hash部分，返回值是map
        SortedMap<Integer, String> subMap =
                vnMap.tailMap(hash);

        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();
        String vstr = subMap.get(i);
        //删除后缀作为实际节点名称
        return vstr.substring(0, vstr.indexOf("&&"));
    }

    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}
