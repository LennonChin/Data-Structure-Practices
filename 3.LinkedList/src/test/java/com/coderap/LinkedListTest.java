package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void init() {
        linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals((long)linkedList.getSize(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(linkedList.isEmpty(), false);
    }

    @Test
    public void add() throws Exception {
        linkedList.add(3, 10);
        Assert.assertEquals((long)linkedList.get(3), 10);
    }

    @Test
    public void addFirst() throws Exception {
        linkedList.addFirst(-1);
        Assert.assertEquals((long)linkedList.getFirst(), -1);
    }

    @Test
    public void addLast() throws Exception {
        linkedList.addLast(100);
        Assert.assertEquals((long)linkedList.getLast(), 100);
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals((long)linkedList.get(2), 2);
    }

    @Test
    public void getFirst() throws Exception {
        Assert.assertEquals((long)linkedList.getFirst(), 4);
    }

    @Test
    public void getLast() throws Exception {
        Assert.assertEquals((long)linkedList.getLast(), 0);
    }

    @Test
    public void set() throws Exception {
        linkedList.set(3, 300);
        Assert.assertEquals((long)linkedList.get(3), 300);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertEquals(linkedList.contains(3), true);
    }

    @Test
    public void remove() throws Exception {
        Assert.assertEquals((long)linkedList.remove(2), 2);
        Assert.assertEquals((long)linkedList.get(2), 1);
    }

    @Test
    public void removeFirst() throws Exception {
        Assert.assertEquals(linkedList.contains(3), true);
    }

    @Test
    public void removeLast() throws Exception {
        Assert.assertEquals(linkedList.contains(3), true);
    }

}