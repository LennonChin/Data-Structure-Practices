package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 集合顶层接口
 * @author: Lennon Chin
 * @create: 2018/08/05 19:31:34
 */
public interface Set<T> {

    void add(T t);
    void remove(T t);
    boolean contains(T t);
    int getSize();
    boolean isEmpty();
}
