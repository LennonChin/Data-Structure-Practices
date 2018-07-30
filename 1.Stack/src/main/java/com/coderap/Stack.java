package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 顶层接口
 * @author: Lennon Chin
 * @create: 2018/07/30 21:02:52
 */
public interface Stack<T> {
    int getSize();
    boolean isEmpty();
    void push(T e);
    T pop();
    T peek();
}
