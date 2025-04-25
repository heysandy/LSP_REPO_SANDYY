// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Exception.html
package org.howard.edu.lspfinal.question2;

/**
 * Thrown when attempting to add a task whose name already exists in the system.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs a DuplicateTaskException with the specified detail message.
     *
     * @param message a description of the duplicate‐task error
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}
