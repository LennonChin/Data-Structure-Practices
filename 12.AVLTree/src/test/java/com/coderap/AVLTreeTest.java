package com.coderap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {
    
    private AVLTree<String, String> avlTree;
    
    @Before
    public void init() {
        avlTree = new AVLTree<>();
        avlTree.add("name", "Tom");
        avlTree.add("age", "20");
        avlTree.add("gender", "Male");
        avlTree.add("country", "China");
        avlTree.add("city", "Shanghai");
    }
    
    @Test
    public void add() throws Exception {
        avlTree.add("birthday", "1999-12-01");
        Assert.assertEquals(avlTree.get("birthday"), "1999-12-01");
    }
    
    @Test
    public void remove() throws Exception {
        avlTree.remove("country");
        Assert.assertEquals(avlTree.contains("country"), false);
    }
    
    @Test
    public void contains() throws Exception {
        Assert.assertEquals(avlTree.contains("age"), true);
    }
    
    @Test
    public void get() throws Exception {
        Assert.assertEquals(avlTree.get("name"), "Tom");
    }
    
    @Test
    public void set() throws Exception {
        avlTree.set("name", "Jack");
        Assert.assertEquals(avlTree.get("name"), "Jack");
    }
    
    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(avlTree.getSize(), 5);
    }
    
    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(avlTree.isEmpty(), false);
    }
    
    @After
    public void after() {
        System.out.println(avlTree.isBST());
        System.out.println(avlTree.isBalanced());
    }
    
}