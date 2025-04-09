package org.howard.edu.lsp.assignment6;

/**
 * Custom exception for operations on empty IntegerSet.
 */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}
