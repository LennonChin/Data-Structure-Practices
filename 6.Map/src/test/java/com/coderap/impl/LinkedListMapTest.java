package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListMapTest {

    private LinkedListMap<String, String> linkedListMap;

    @Before
    public void init() {
        linkedListMap = new LinkedListMap<>();
        linkedListMap.add("name", "Tom");
        linkedListMap.add("age", "20");
        linkedListMap.add("gender", "Male");
        linkedListMap.add("country", "China");
        linkedListMap.add("city", "Shanghai");
    }

    @Test
    public void add() throws Exception {
        linkedListMap.add("birthday", "1999-12-01");
        Assert.assertEquals(linkedListMap.get("birthday"), "1999-12-01");
    }

    @Test
    public void remove() throws Exception {
        linkedListMap.remove("country");
        Assert.assertEquals(linkedListMap.contains("country"), false);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertEquals(linkedListMap.contains("age"), true);
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(linkedListMap.get("name"), "Tom");
    }

    @Test
    public void set() throws Exception {
        linkedListMap.set("name", "Jack");
        Assert.assertEquals(linkedListMap.get("name"), "Jack");
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(linkedListMap.getSize(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(linkedListMap.isEmpty(), false);
    }

}