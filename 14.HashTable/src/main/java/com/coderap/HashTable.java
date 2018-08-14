package com.coderap;

import java.util.TreeMap;

/**
 * @program: Data-Structure-Practices
 * @description: 哈希表
 * @author: Lennon Chin
 * @create: 2018/08/14 22:13:21
 */
public class HashTable<K, V> {
    
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
        this(97);
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
        }
    }
    
    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            size--;
            return map.remove(key);
        } else {
            return null;
        }
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
