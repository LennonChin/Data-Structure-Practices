package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopQueueTest {

    private LoopQueue<Integer> loopQueue;

    @Before
    public void init() {
        loopQueue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals((long)loopQueue.getSize(), 5);
    }

    @Test
    public void getCapacity() throws Exception {
        Assert.assertEquals((long)loopQueue.getCapacity(), 16);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(loopQueue.isEmpty(), false);
    }

    @Test
    public void enqueue() throws Exception {
        loopQueue.enqueue(5);
        Assert.assertEquals((long)loopQueue.getSize(), 6);
    }

    @Test
    public void dequeue() throws Exception {
        Assert.assertEquals((long)loopQueue.dequeue(), 0);
        Assert.assertEquals((long)loopQueue.getSize(), 4);
    }

    @Test
    public void getFront() throws Exception {
        Assert.assertEquals((long)loopQueue.getFront(), 0);
    }

}