package com.xunhuan.java.base.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tianh
 * @description: 一致性hash ， KETAMA_HASH实现
 * @date 2021/3/29 10:14 下午
 */
public class ConsistentHash_KETAMA {

    private TreeMap<Long, String> realNodes = new TreeMap();
    private String[] nodes;

    public ConsistentHash_KETAMA(String[] nodes) {
        this.nodes = Arrays.copyOf(nodes, nodes.length);
        initalization();
    }

    /**
     * 初始化哈希环
     * 循环计算每个node名称的哈希值，将其放入treeMap
     */
    private void initalization() {
        for (String nodeName : nodes) {
            realNodes.put(hash(nodeName, 0), nodeName);
        }
    }

    public byte[] md5(String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(key.getBytes(StandardCharsets.UTF_8));
            return md5.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Long hash(String nodeName, int number) {
        byte[] digest = md5(nodeName);
        return (((long) (digest[3 + number * 4] & 0xFF) << 24)
                | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                | (digest[number * 4] & 0xFF))
                & 0xFFFFFFFFL;
    }

    /**
     * 根据节点key返回对应名称
     *
     * @param key
     * @return
     */
    public String selectNode(String key) {
        Long hashOfKey = hash(key, 0);
        if (!realNodes.containsKey(hashOfKey)) {
            //ceilingEntry()的作用是得到比hashOfKey大的第一个Entry
            Map.Entry<Long, String> entry = realNodes.ceilingEntry(hashOfKey);
            if (entry != null) {
                return entry.getValue();
            } else {
                return nodes[0];
            }
        } else {
            return realNodes.get(hashOfKey);
        }
    }

    private void printTreeNode() {
        if (realNodes != null && !realNodes.isEmpty()) {
            realNodes.forEach((hashKey, node) ->
                    System.out.println(node + " ==> " + hashKey)
            );
        } else
            System.out.println("Cycle is Empty");
    }

    public static void main(String[] args) {
        String[] nodes = new String[]{"192.168.13.1:8080", "192.168.13.2:8080", "192.168.13.3:8080", "192.168.13.4:8080"};
        ConsistentHash_KETAMA consistentHash = new ConsistentHash_KETAMA(nodes);
        consistentHash.printTreeNode();
        System.out.println(consistentHash.selectNode("123") + " ==>" + consistentHash.hash("123", 0));
        System.out.println(consistentHash.selectNode("456") + " ==>" + consistentHash.hash("456", 0));
        System.out.println(consistentHash.selectNode("789"));
        System.out.println(consistentHash.selectNode("000"));
        System.out.println(consistentHash.selectNode("1231111") + " ==>" + consistentHash.hash("1231111", 0));
        System.out.println(consistentHash.selectNode("2222"));
        System.out.println(consistentHash.selectNode("111"));
        System.out.println(consistentHash.selectNode("2222"));
        System.out.println(consistentHash.selectNode("223"));
    }
}
