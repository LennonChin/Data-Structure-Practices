package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {

    private Array<Integer> array;

    @Before
    public void init() {
        array = new Array<Integer>();

        for (int i = 0; i < 16; i++) {
            array.addLast(i);
        }
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(array.getSize(), 16);
    }

    @Test
    public void getCapacity() throws Exception {
        Assert.assertEquals(array.getCapacity(), 16);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(array.isEmpty(), false);
    }

    @Test
    public void addLast() throws Exception {
        array.addLast(200);
        long result = (long)array.get(array.getSize() - 1);
        Assert.assertEquals(result, 200);
    }

    @Test
    public void addFirst() throws Exception {
        array.addFirst(-1);
        long result = (long)array.get(0);
        Assert.assertEquals(result, -1);
    }

    @Test
    public void add() throws Exception {
        array.add(2, 100);
        long result = (long)array.get(2);
        Assert.assertEquals(result, 100);
    }

    @Test
    public void get() throws Exception {
        long result = (long)array.get(4);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void set() throws Exception {
        array.set(5, 120);
        long result = (long)array.get(5);
        Assert.assertEquals(result, 120);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertEquals(array.contains(8), true);
    }

    @Test
    public void find() throws Exception {
        long result = (long)array.find(6);
        Assert.assertNotEquals(result, -1);
    }

    @Test
    public void remove() throws Exception {
        long result = (long)array.remove(4);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void removeFirst() throws Exception {
        array.removeFirst();
        long result = (long)array.get(0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void removeLast() throws Exception {
        array.removeLast();
        long result = (long)array.get(array.getSize() - 1);
        Assert.assertEquals(result, 14);
    }

    @Test
    public void removeElement() throws Exception {
        array.removeElement(6);
        long result = (long)array.get(6);
        Assert.assertNotEquals(result, 6);
    }

    @Test
    public void resize() {
        for (int i = 0; i < 12; i++) {
            array.removeLast();
        }
        // 已减容
        Assert.assertEquals(array.getCapacity(), 8);
        for (int i = 0; i < 5; i++) {
            array.addLast(i);
        }
        // 已扩容
        Assert.assertEquals(array.getCapacity(), 16);
    }

}