package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
    
    private HashTable<String, String> hashTable;
    
    @Before
    public void init() {
        hashTable = new HashTable<>();
        hashTable.add("name", "Tom");
        hashTable.add("age", "20");
        hashTable.add("gender", "Male");
        hashTable.add("country", "China");
        hashTable.add("city", "Shanghai");
    }
    
    @Test
    public void add() throws Exception {
        hashTable.add("birthday", "1999-12-01");
        Assert.assertEquals(hashTable.get("birthday"), "1999-12-01");
    }
    
    @Test
    public void remove() throws Exception {
        hashTable.remove("country");
        Assert.assertEquals(hashTable.contains("country"), false);
    }
    
    @Test
    public void contains() throws Exception {
        Assert.assertEquals(hashTable.contains("age"), true);
    }
    
    @Test
    public void get() throws Exception {
        Assert.assertEquals(hashTable.get("name"), "Tom");
    }
    
    @Test
    public void set() throws Exception {
        hashTable.set("name", "Jack");
        Assert.assertEquals(hashTable.get("name"), "Jack");
    }
    
    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(hashTable.getSize(), 5);
    }
    
}