package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListQueueTest {

    private LinkedListQueue<Integer> linkedListQueue;

    @Before
    public void init() {
        linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals((long)linkedListQueue.getSize(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(linkedListQueue.isEmpty(), false);
    }

    @Test
    public void enqueue() throws Exception {
        linkedListQueue.enqueue(5);
        Assert.assertEquals((long)linkedListQueue.getSize(), 6);
    }

    @Test
    public void dequeue() throws Exception {
        Assert.assertEquals((long)linkedListQueue.dequeue(), 0);
        Assert.assertEquals((long)linkedListQueue.getSize(), 4);
    }

    @Test
    public void getFront() throws Exception {
        Assert.assertEquals((long)linkedListQueue.getFront(), 0);
    }

}