package com.xunhuan.java.algorithm.geekbang.algorithm_01.graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图  广度优先(最短路径)、深度优先(不能保证最短路径)算法
 *
 * 广度优先算法时间复杂度是 O(V+E)，其中，V 表示顶点的个数，E 表示边的个数，可以简写为 O(E)，空间复杂度是 O(V)
 *
 * 深度优先算法时间复杂度是 O(E)，空间复杂度是 O(V)
 *
 */
public class P31_Graph {
    boolean found = false;
    private int v; // 顶点数量

    private LinkedList<Integer>[] adj; // 邻接表

    public P31_Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 加边 建立关系
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) { // 无向图一条边需要加2次
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * 广度搜索
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }


    /**
     * 深度搜索(走迷宫式，回溯)
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            if (found) {
                return;
            }
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    public static void main(String[] args) {
        P31_Graph p31_graph = new P31_Graph(8);
        p31_graph.addEdge(0, 1);
        p31_graph.addEdge(0, 3);
        p31_graph.addEdge(1, 2);
        p31_graph.addEdge(3, 4);
        p31_graph.addEdge(1, 4);
        p31_graph.addEdge(2, 5);
        p31_graph.addEdge(4, 5);
        p31_graph.addEdge(4, 6);
        p31_graph.addEdge(5, 7);
        p31_graph.addEdge(6, 7);

        p31_graph.dfs(0, 6);
    }
}
