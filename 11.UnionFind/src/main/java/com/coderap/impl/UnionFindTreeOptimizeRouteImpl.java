package com.coderap.impl;

import com.coderap.UnionFind;

/**
 * @program: Data-Structure-Practices
 * @description: 以森林为基础而实现的并查集
 * @author: Lennon Chin
 * @create: 2018/08/11 19:07:47
 */
public class UnionFindTreeOptimizeRouteImpl implements UnionFind {
    
    private int[] parent;
    private int[] treesRank;
    
    public UnionFindTreeOptimizeRouteImpl(int size) {
        
        parent = new int[size];
        // 记录每棵树的高度
        treesRank = new int[size];
        
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            treesRank[i] = 1;
        }
    }
    
    @Override
    public int getSize() {
        return parent.length;
    }
    
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (treesRank[pRoot] < treesRank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (treesRank[pRoot] > treesRank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            // 两树等高时，合并后，作为父节点的那棵树高度需要 +1
            parent[qRoot] = pRoot;
            treesRank[pRoot] += 1;
        }
    }
    
    /**
     * 查找过程，查找元素p所对应的集合编号
     * 复杂度为O(h)，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        // 一直判断自己是否和自己的父节点相等，如果相等说明循环到了根节点
        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
