package com.xunhuan.java.base.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author tianh
 * @description:
 * @date 2021/3/31 12:23 下午
 */
public class ConsistentHash_FNV {

    //服务器列表名称
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    //key是服务器的hash值，value是服务器的名称
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println("---------------");
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,String自带的hashcode分布不均
     */
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

    private static String getServer(String str) {
        //求出hash值
        int hash = getHash(str);

        //获取大于hash部分，返回值是map
        SortedMap<Integer, String> subMap =
                sortedMap.tailMap(hash);

        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();

        return subMap.get(i);
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};

        for (int i = 0; i < nodes.length; i++)
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
    }

}
