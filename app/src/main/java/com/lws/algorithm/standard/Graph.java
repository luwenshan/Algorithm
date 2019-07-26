package com.lws.algorithm.standard;

import java.util.LinkedList;
import java.util.Queue;

// 无向图
public class Graph {
    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 无向图一条边存两次
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索BFS
     *
     * @param s 起始顶点
     * @param t 终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] pre = new int[v];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        while (queue.size() > 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        break;
                    }
                    visited[q] = true;
                    queue.offer(q);
                }
            }
        }
    }

    private boolean found = false;

    /**
     * 深度优先搜索DFS
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        dfsRecurse(s, t, visited, pre);
        print(pre, s, t);
    }

    private void dfsRecurse(int w, int t, boolean[] visited, int[] pre) {
        if (found) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                pre[q] = w;
                dfsRecurse(q, t, visited, pre);
            }
        }
    }

    // 递归打印 s->t 的路径
    private void print(int[] pre, int s, int t) {
        if (pre[t] != -1 && t != s) {
            print(pre, s, pre[t]);
        }
        System.out.println(t + " ");
    }
}
