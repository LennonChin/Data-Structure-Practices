package com.coderap;

import java.util.TreeMap;

/**
 * @program: Data-Structure-Practices
 * @description: 哈希表
 * @author: Lennon Chin
 * @create: 2018/08/14 22:13:21
 */
public class HashTable<K, V> {
    
    // 素数表
    private int[] capacities = {61, 83, 113, 151, 211, 281, 379, 509, 683, 911, 1217, 1627, 2179, 2909, 3881, 6907, 9209, 12281, 16381, 21841, 29123, 38833, 51787, 69061, 92083, 122777, 163729, 218357, 291143, 388211, 517619, 690163, 999983, 1226959, 1635947, 2181271, 2908361, 3877817, 5170427, 6893911, 9191891, 12255871, 16341163, 21788233, 29050993, 38734667, 51646229, 68861641, 91815541, 122420729, 163227661, 217636919, 290182597, 386910137, 515880193, 687840301, 917120411};
    
    // 扩容上界和缩容下界
    private final static int upperTolerance = 31;
    private final static int lowerTolerance = 3;
    // 初始数组容量
    private int defaultCapacityIndex = 0;
    
    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;
    
    public HashTable() {
        this.M = capacities[defaultCapacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
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
            if (size >= upperTolerance * M && defaultCapacityIndex + 1 < capacities.length) {
                // 需要扩容
                defaultCapacityIndex++;
                resize(capacities[defaultCapacityIndex]);
            }
        }
    }
    
    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            size--;
            if (size < lowerTolerance * M && defaultCapacityIndex - 1 >= 0) {
                // 需要缩容
                defaultCapacityIndex--;
                resize(capacities[defaultCapacityIndex]);
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
