package org.howard.edu.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for IntegerSet.
 */
public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        set1.add(5);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        set1.add(7);
        assertTrue(set1.contains(7));
        assertFalse(set1.contains(10));
    }

    @Test
    @DisplayName("Test case for largest()")
    public void testLargest() throws IntegerSetException {
        set1.add(3);
        set1.add(9);
        set1.add(5);
        assertEquals(9, set1.largest());
    }

    @Test
    @DisplayName("Test case for largest() with exception")
    public void testLargestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
        assertEquals("Set is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest()")
    public void testSmallest() throws IntegerSetException {
        set1.add(8);
        set1.add(2);
        set1.add(5);
        assertEquals(2, set1.smallest());
    }

    @Test
    @DisplayName("Test case for smallest() with exception")
    public void testSmallestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
        assertEquals("Set is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for add()")
    public void testAdd() {
        set1.add(4);
        set1.add(
