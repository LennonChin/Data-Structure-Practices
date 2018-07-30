package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 顶层接口
 * @author: Lennon Chin
 * @create: 2018/07/30 21:57:52
 */
public interface Queue<T> {
    int getSize();
    boolean isEmpty();
    void enqueue(T e);
    T dequeue();
    T getFront();
}
