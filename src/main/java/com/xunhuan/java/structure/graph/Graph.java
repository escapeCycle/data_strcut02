package com.xunhuan.java.structure.graph;

import com.xunhuan.java.structure.stack.MyStack;

/**
 * 图结构
 * 例:
 *      B —— —— E
 *    / | \
 *   /  |  \
 *  C   |   D
 *    \ |
 *      A
 *
 * @author tianhuan
 * @date 2018-12-27 15:02
 **/
public class Graph {

    private Vertex[] vertexs;
    private int currentSize;

    private int[][] adjMat;

    private MyStack stack = new MyStack();

    private int currentIndex;


    public Graph(int size) {
        vertexs = new Vertex[size];
        adjMat = new int[size][size];
        for (int i = 0; i < size; i++) {
            adjMat[i][i] = 1;
        }
    }

    /**
     * 向图中增加一个顶点
     *
     * @param v
     */
    public void addVertex(Vertex v) {
        vertexs[currentSize++] = v;
    }

    /**
     * 加边
     * @param v1
     * @param v2
     */
    public void addEdge(String v1, String v2) {
        /*
            找到两个顶点的下标
         */
        int index1 = 0;
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i].getValue().equals(v1)) {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i].getValue().equals(v2)) {
                index2 = i;
                break;
            }
        }
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    /**
     * 深度优先搜索算法遍历图
     */
    public void dfs(){

        vertexs[0].setVisited(true);
        stack.push(0);
        System.out.println(vertexs[0].getValue());
        out:while (!stack.isEmpty()){
            for(int i = currentIndex+1;i<vertexs.length;i++){
                /*
                    如果和下一个遍历的元素是通的
                 */
                if(adjMat[currentIndex][i] == 1 && !vertexs[i].isVisited()){
                    /*
                        把下一个元素压入栈中
                     */
                    stack.push(i);
                    vertexs[i].setVisited(true);
                    System.out.println(vertexs[i].getValue());
                    continue out;
                }
            }
            /*
                弹出栈顶元素
             */
            stack.pop();
            /*
                修改当前位置为栈顶元素的位置
             */
            if(!stack.isEmpty()){
                currentIndex = (int)stack.peek();
            }
        }

    }


    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        /*
            加点
         */
        Graph g = new Graph(5);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        /*
            加边
         */
        g.addEdge("A","C");
        g.addEdge("B","C");
        g.addEdge("A","B");
        g.addEdge("B","D");
        g.addEdge("B","E");


        g.dfs();

    }

}
