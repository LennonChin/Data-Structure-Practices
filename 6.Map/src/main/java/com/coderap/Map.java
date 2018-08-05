package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 映射顶层接口
 * @author: Lennon Chin
 * @create: 2018/08/05 22:10:24
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
