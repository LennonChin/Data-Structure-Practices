package com.coderap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {

    private Array array;

    @Before
    public void init() {
        array = new Array(20);

        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
    }

    @Test
    public void getSize() throws Exception {
        System.out.println(array.getSize());
    }

    @Test
    public void getCapacity() throws Exception {
        System.out.println(array.getCapacity());
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(array.isEmpty());
    }

    @Test
    public void addLast() throws Exception {
        array.addLast(200);
        System.out.println(array);
    }

    @Test
    public void addFirst() throws Exception {
        array.addFirst(-1);
        System.out.println(array);
    }

    @Test
    public void add() throws Exception {
        array.add(2, 100);
        System.out.println(array);
    }

    @Test
    public void get() throws Exception {
        System.out.println(array.get(4));
    }

    @Test
    public void set() throws Exception {
        array.set(5, 120);
        System.out.println(array);
    }

    @Test
    public void contains() throws Exception {
        System.out.println(array.contains(120));
    }

    @Test
    public void find() throws Exception {
        System.out.println(array.find(120));
    }

    @Test
    public void remove() throws Exception {
        array.remove(4);
        System.out.println(array);
    }

    @Test
    public void removeFirst() throws Exception {
        array.removeFirst();
        System.out.println(array);
    }

    @Test
    public void removeLast() throws Exception {
        array.removeLast();
        System.out.println(array);
    }

    @Test
    public void removeElement() throws Exception {
        array.removeElement(6);
        System.out.println(array);
    }

}