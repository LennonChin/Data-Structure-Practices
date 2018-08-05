package com.coderap.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class LinkedListSetTest {

    private LinkedListSet<Integer> linkedListSet;
    private Random random = new Random();
    private int count = 1000;

    @Before
    public void init() {
        linkedListSet = new LinkedListSet<>();
        for (int i = 0; i < count; i++) {
            linkedListSet.add(random.nextInt(count / 10));
        }
    }

    @Test
    public void add() throws Exception {
        linkedListSet.add(random.nextInt(count / 10));
    }

    @Test
    public void remove() throws Exception {
        linkedListSet.remove(random.nextInt(count / 10));
    }

    @Test
    public void contains() throws Exception {
        linkedListSet.contains(random.nextInt(count / 10));
    }

    @Test
    public void getSize() throws Exception {
        System.out.println(linkedListSet.getSize());
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(linkedListSet.isEmpty());
    }

}