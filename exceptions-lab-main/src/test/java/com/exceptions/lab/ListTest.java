package com.exceptions.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    private RealList<Double> list;

    @BeforeEach
    void setUp() {
        list = new RealList<>();
    }

    @Test
    void testAdd() {
        list.add(1.0);
        list.add(2.0);
        assertEquals(2, list.size());
        assertTrue(list.contains(1.0));
        assertTrue(list.contains(2.0));
    }

    @Test
    void testPut() {
        list.add(1.0);
        list.add(2.0);
        assertEquals(1, list.put(0, 10.0));
        assertTrue(list.contains(10.0));
        assertFalse(list.contains(1.0));
    }

    @Test
    void testPut_IndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.put(0, 10.0));
    }

    @Test
    void testRemoveByIndex() {
        list.add(1.0);
        list.add(2.5);
        assertEquals(1, list.remove(0));
        assertEquals(1, list.size());
        assertFalse(list.contains(1.0));
        assertTrue(list.contains(2.5));
    }

    @Test
    void testRemoveByIndex_IndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testRemoveByObject() {
        list.add(1.0);
        list.add(2.0);
        assertTrue(list.remove(1.0));
        assertFalse(list.contains(1.0));
        assertTrue(list.contains(2.0));
    }

    @Test
    void testRemoveByObject_NotFound() {
        list.add(1.0);
        assertFalse(list.remove(10.0));
    }

    @Test
    void testAddAll() {
        list.addAll(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        assertEquals(4, list.size());
        assertTrue(list.contains(3.0));
    }

    @Test
    void testContains() {
        list.add(1.0);
        assertTrue(list.contains(1.0));
        assertFalse(list.contains(2.0));
    }

    @Test
    void testSize() {
        list.add(1.0);
        list.add(2.0);
        assertEquals(2, list.size());
    }
}
