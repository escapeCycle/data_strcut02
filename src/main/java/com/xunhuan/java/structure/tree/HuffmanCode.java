package com.xunhuan.java.structure.tree;

import java.io.*;
import java.util.*;

/**
 * 赫夫曼编码(压缩文件)
 *
 * @author tianhuan
 * @date 2018-12-12 18:53
 **/
public class HuffmanCode {

    public static void main(String[] args) {
        HuffmanCode code = new HuffmanCode();
//        String msg = "can you can a can as a can canner can a can.";
        String msg = "asbcjkasbcsd csksdvdcvksdvs.Xc./szc,sd;lcsamdcvsadvsd'vdsv,sd/v.sd.v'sd;vk[sdvsd,v/sd,vds';vls\\\n" +
                "vsvsvls'vds.v/sv.s/vspvls/v.sd/.v/sd.;s['vsd;v,s/vc,ZKXHsgaudibcvsjabjgsjc].";

        byte[] bytes = msg.getBytes();

        byte[] b = code.huffmanZip(bytes);
        System.out.println(bytes.length);
        System.out.println(b.length);

        byte[] newBytes = code.decode(huffCodes, b);
        System.out.println(new String(newBytes));

//        System.out.println(Integer.parseInt("1111111101",2));
//        System.out.println((byte) Integer.parseInt("1111111101",2));
//
//        String s = code.byteToBitStr(true, (byte) 10000000);
//        System.out.println(s);


        byte a = -23;
        int aa = a;
        System.out.println(Integer.toBinaryString(a));

//        try {
//            code.zipFile("1", "222.zip");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            code.unZip("222.zip","3");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }

    /**
     * 文件压缩
     *
     * @param src 文件路径
     * @param dst 输出路径
     * @throws IOException
     */
    public void zipFile(String src, String dst) throws IOException {
        /*
            创建一个输入流
         */
        InputStream in = new FileInputStream(src);

        byte[] b = new byte[in.available()];
        in.read(b);
        in.close();
        byte[] byteZip = huffmanZip(b);
        System.out.println(b.length);
        System.out.println(byteZip.length);
        /*
            输出流
         */
        OutputStream os = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(byteZip);
        oos.writeObject(huffCodes);
        oos.close();
        os.close();
    }

    /**
     * 解压缩
     * @param src
     * @param dst
     * @throws Exception
     */
    public void unZip(String src, String dst) throws Exception {
        /*
            创建一个输入流
         */
        InputStream is = new FileInputStream(src);

        ObjectInputStream ois = new ObjectInputStream(is);

        byte[] b = (byte[]) ois.readObject();
        /*
            读取赫夫曼编码表
         */
        Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
        ois.close();
        is.close();
        /*
            解码
         */
        byte[] deByte = decode(codes, b);
        /*
            创建一个输出流
         */
        OutputStream os = new FileOutputStream(dst);
        os.write(deByte);
        os.close();
    }

    /**
     * 赫夫曼解码
     *
     * @param huffCodes
     * @param bytes
     * @return
     */
    private byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = (i == bytes.length - 1);
            sb.append(byteToBitStr(!flag, b));
        }
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        /*
            处理字符串
         */
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = sb.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        /*
            将集合转成数组
         */
        byte[] b = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private String byteToBitStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    private byte[] huffmanZip(byte[] bytes) {
        /*
            先统计每一个byte出现的次数 , 并放入一个集合中
         */
        List<HuffmanNode> nodes = getNodes(bytes); 
        /*
            创建一颗赫夫曼树
         */
        HuffmanNode tree = createHuffmanTree(nodes);
        /*
            创建一个赫夫曼编码表
         */
        Map<Byte, String> huffmanCode = getCodes(tree);
        /*
            编码
         */
        byte[] b = zip(bytes, huffmanCode);

        return b;
    }

    /**
     * 进行赫夫曼编码
     *
     * @param bytes
     * @param huffmanCode
     * @return
     */
    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCode.get(b));
        }
        /*
            8位一组
         */
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(strByte, 2);
            by[index] = byt;
            index++;
        }
        return by;
    }

    /**
     * 存储路径
     */
    static StringBuilder sb = new StringBuilder();

    /**
     * 存储编码
     */

    static Map<Byte, String> huffCodes = new HashMap<>();

    private Map<Byte, String> getCodes(HuffmanNode tree) {
        if (tree == null) {
            return null;
        }
        getCodes(tree.left, "0", sb);
        getCodes(tree.right, "1", sb);

        return huffCodes;
    }

    private void getCodes(HuffmanNode node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null) {
            getCodes(node.left, "0", sb2);
            getCodes(node.right, "1", sb2);
        } else {
            huffCodes.put(node.data, sb2.toString());
        }

    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes
     * @return
     */
    private HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        while (nodes.size() > 1) {
            /*
            排序
            */
            Collections.sort(nodes);

            /*
                取出权值最小的两个二叉树
             */
            HuffmanNode left = nodes.get(nodes.size() - 1);
            HuffmanNode right = nodes.get(nodes.size() - 2);
            /*
                创建一个新的二叉树
             */
            HuffmanNode parent = new HuffmanNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            /*
                把取出来的两个二叉树移除
             */
            nodes.remove(left);
            nodes.remove(right);
            /*
                放入原来的二叉树集合中
             */
            nodes.add(parent);
        }
        return nodes.get(0);

    }

    private List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> nodes = new ArrayList<>();

        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }


}
