package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedBlackTreeTest {
    
    private RedBlackTree<String, String> redBlackTree;
    
    @Before
    public void init() {
        redBlackTree = new RedBlackTree<>();
        redBlackTree.add("name", "Tom");
        redBlackTree.add("age", "20");
        redBlackTree.add("gender", "Male");
        redBlackTree.add("country", "China");
        redBlackTree.add("city", "Shanghai");
    }
    
    @Test
    public void add() throws Exception {
        redBlackTree.add("birthday", "1999-12-01");
        Assert.assertEquals(redBlackTree.get("birthday"), "1999-12-01");
    }
    
    @Test
    public void remove() throws Exception {
        redBlackTree.remove("country");
        Assert.assertEquals(redBlackTree.contains("country"), false);
    }
    
    @Test
    public void contains() throws Exception {
        Assert.assertEquals(redBlackTree.contains("age"), true);
    }
    
    @Test
    public void get() throws Exception {
        Assert.assertEquals(redBlackTree.get("name"), "Tom");
    }
    
    @Test
    public void set() throws Exception {
        redBlackTree.set("name", "Jack");
        Assert.assertEquals(redBlackTree.get("name"), "Jack");
    }
    
    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(redBlackTree.getSize(), 5);
    }
    
    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(redBlackTree.isEmpty(), false);
    }
    
}