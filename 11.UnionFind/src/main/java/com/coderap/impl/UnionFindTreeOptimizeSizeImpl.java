package com.coderap.impl;

import com.coderap.UnionFind;

/**
 * @program: Data-Structure-Practices
 * @description: 以森林为基础而实现的并查集
 * @author: Lennon Chin
 * @create: 2018/08/11 19:07:47
 */
public class UnionFindTreeOptimizeSizeImpl implements UnionFind {
    
    private int[] parent;
    private int[] treesSize;
    
    public UnionFindTreeOptimizeSizeImpl(int size) {
        
        parent = new int[size];
        // 记录每棵树的size（高度）
        treesSize = new int[size];
        
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            treesSize[i] = 1;
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
        if (treesSize[pRoot] < treesSize[qRoot]) {
            parent[pRoot] = qRoot;
            // 更新树高度值
            treesSize[qRoot] += treesSize[pRoot];
        } else {
            parent[qRoot] = pRoot;
            // 更新树高度值
            treesSize[pRoot] += treesSize[qRoot];
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
            p = parent[p];
        }
        return p;
    }
}
