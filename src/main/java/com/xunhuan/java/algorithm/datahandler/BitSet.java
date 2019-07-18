package com.xunhuan.java.algorithm.datahandler;


/**
 * 比特数组，处理海量 整数数据 去重
 */
public class BitSet {
    int[] bitset;

    public BitSet(int size) {
        bitset = new int[(size >> 5) + 1]; // divide by 32
    }

    boolean get(int pos) {
        int wordNumber = (pos >> 5); // divide by 32
        int bitNumber = (pos & 0x1F); // mod 32
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5); // divide by 32
        int bitNumber = (pos & 0x1F); // mod 32
        bitset[wordNumber] |= 1 << bitNumber;
    }


    public static void main(String[] args) {

        BitSet bitSet = new BitSet(100000);

        bitSet.set(1);
        bitSet.set(5);
        bitSet.set(9);
        bitSet.set(11);
        bitSet.set(11);
        bitSet.set(11);
        bitSet.set(11);
        bitSet.set(11);
        bitSet.set(15);
        bitSet.set(99);
        bitSet.set(10000);
        bitSet.set(888);


        System.out.println(bitSet.get(88));
    }
}