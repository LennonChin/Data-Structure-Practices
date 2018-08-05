package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTMapTest {

    private BSTMap<String, String> bstMap;

    @Before
    public void init() {
        bstMap = new BSTMap<>();
        bstMap.add("name", "Tom");
        bstMap.add("age", "20");
        bstMap.add("gender", "Male");
        bstMap.add("country", "China");
        bstMap.add("city", "Shanghai");
    }

    @Test
    public void add() throws Exception {
        bstMap.add("birthday", "1999-12-01");
        Assert.assertEquals(bstMap.get("birthday"), "1999-12-01");
    }

    @Test
    public void remove() throws Exception {
        bstMap.remove("country");
        Assert.assertEquals(bstMap.contains("country"), false);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertEquals(bstMap.contains("age"), true);
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(bstMap.get("name"), "Tom");
    }

    @Test
    public void set() throws Exception {
        bstMap.set("name", "Jack");
        Assert.assertEquals(bstMap.get("name"), "Jack");
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(bstMap.getSize(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(bstMap.isEmpty(), false);
    }

}