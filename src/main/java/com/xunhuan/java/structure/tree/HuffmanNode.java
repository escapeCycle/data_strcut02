package com.xunhuan.java.structure.tree;

/**
 *
 * @author tianhuan
 * @date 2018-12-12 18:53
 **/
public class HuffmanNode implements Comparable<HuffmanNode>{
    Byte data;
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data,int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return -(this.weight - o.weight);
    }
}
