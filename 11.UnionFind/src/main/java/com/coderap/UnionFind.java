package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 顶层接口
 * @author: Lennon Chin
 * @create: 2018/08/11 18:16:54
 */
public interface UnionFind {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
