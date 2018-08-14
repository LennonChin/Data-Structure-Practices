package com.coderap;

import java.util.TreeMap;

/**
 * @program: Data-Structure-Practices
 * @description: 哈希表
 * @author: Lennon Chin
 * @create: 2018/08/14 22:13:21
 */
public class HashTable<K, V> {
    
    // 扩容上界和缩容下界
    private final static int upperTolerance = 31;
    private final static int lowerTolerance = 3;
    // 初始数组容量
    private final static int defaultCapacity = 7;
    
    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;
    
    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }
    
    public HashTable() {
        this(defaultCapacity);
    }
    
    /**
     * hash方法
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        // 负数取正然后取模
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public int getSize() {
        return size;
    }
    
    /**
     * 添加操作，如果已存在就视为修改
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            // 修改操作
            map.put(key, value);
        } else {
            // 添加操作
            map.put(key, value);
            size++;
            if (size >= upperTolerance * M) {
                // 需要扩容，扩容一倍
                resize(2 * M);
            }
        }
    }
    
    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            size--;
            if (size < lowerTolerance * M && M / 2 > defaultCapacity) {
                // 需要缩容
                resize(M / 2);
            }
            return map.remove(key);
        } else {
            return null;
        }
    }
    
    /**
     * 重整数组大小
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        
        // 记录原来的M
        int loopCount = M;
        // 将M赋值为新值，因为hash方法中需要用到新的M
        M = newCapacity;
        // 循环重组
        for (int i = 0; i < loopCount; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }
    
    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Key: " + key + " doesn't exist.");
        }
        map.put(key, value);
    }
    
    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }
    
    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }
}
