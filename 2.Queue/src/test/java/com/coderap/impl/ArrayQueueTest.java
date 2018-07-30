package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    private ArrayQueue<Integer> arrayQueue;

    @Before
    public void init() {
        arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals((long)arrayQueue.getSize(), 5);
    }

    @Test
    public void getCapacity() throws Exception {
        Assert.assertEquals((long)arrayQueue.getCapacity(), 16);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(arrayQueue.isEmpty(), false);
    }

    @Test
    public void enqueue() throws Exception {
        arrayQueue.enqueue(5);
        Assert.assertEquals((long)arrayQueue.getSize(), 6);
    }

    @Test
    public void dequeue() throws Exception {
        Assert.assertEquals((long)arrayQueue.dequeue(), 0);
        Assert.assertEquals((long)arrayQueue.getSize(), 4);
    }

    @Test
    public void getFront() throws Exception {
        Assert.assertEquals((long)arrayQueue.getFront(), 0);
    }

}