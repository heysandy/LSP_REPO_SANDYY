package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet represents a set of unique integers and supports typical set operations
 * such as union, intersection, difference, and complement.
 * Duplicates are not allowed.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor. Initializes an empty set.
     */
    public IntegerSet() {}

    /**
     * Constructor that initializes the set with values from an existing ArrayList.
     * Duplicates will be removed.
     * 
     * @param set ArrayList of integers to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (int val : set) {
            if (!this.set.contains(val)) {
                this.set.add(val);
            }
        }
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares two IntegerSet objects for equality.
     * 
     * @param o the object to compare
     * @return true if sets contain the same elements, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        List<Integer> sortedThis = new ArrayList<>(this.set);
        List<Integer> sortedOther = new ArrayList<>(other.set);
        Collections.sort(sortedThis);
        Collections.sort(sortedOther);
        return sortedThis.equals(sortedOther);
    }

    /**
     * Checks whether a value exists in the set.
     * 
     * @param value the value to search for
     * @return true if the value exists, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * 
     * @return the largest integer
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     * 
     * @return the smallest integer
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if not already present.
     * 
     * @param item the item to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * 
     * @param item the item to remove
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Updates this set to the union of itself and another set.
     * 
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int val : intSetb.set) {
            if (!set.contains(val)) {
                set.add(val);
            }
        }
    }

    /**
     * Updates this set to the intersection of itself and another set.
     * 
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Updates this set to the difference (this set - intSetb).
     * 
     * @param intSetb the set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Updates this set to be the complement (elements in intSetb but not in this set).
     * 
     * @param intSetb the universal set to compare against
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>(intSetb.set);
        result.removeAll(this.set);
        this.set = result;
    }

    /**
     * Checks whether the set is empty.
     * 
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return string representation of the set
     */
    public String toString() {
        return set.toString();
    }
}
