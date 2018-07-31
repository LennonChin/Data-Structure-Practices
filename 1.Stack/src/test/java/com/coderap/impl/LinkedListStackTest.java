package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListStackTest {

    private LinkedListStack<Integer> linkedListStack;

    @Before
    public void init() {
        linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack);
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals((long)linkedListStack.getSize(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(linkedListStack.isEmpty(), false);
    }

    @Test
    public void push() throws Exception {
        linkedListStack.push(5);
        Assert.assertEquals((long)linkedListStack.pop(), 5);
    }

    @Test
    public void pop() throws Exception {
        long pop = (long)linkedListStack.pop();
        Assert.assertEquals(pop, 4);
    }

    @Test
    public void peek() throws Exception {
        Assert.assertEquals((long)linkedListStack.peek(), 4);
    }

}