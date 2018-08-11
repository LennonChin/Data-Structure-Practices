package com.coderap.impl;

import com.coderap.UnionFind;

/**
 * @program: Data-Structure-Practices
 * @description: 使用数组进行模拟基本实现
 * @author: Lennon Chin
 * @create: 2018/08/11 18:23:50
 */
public class UnionFindBasicImpl implements UnionFind {
    
    private int[] id;
    
    public UnionFindBasicImpl(int size) {
        id = new int[size];
        // 每个元素所对应的编号都不一样
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    
    @Override
    public int getSize() {
        return id.length;
    }
    
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
    
    /**
     * 查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }
}
