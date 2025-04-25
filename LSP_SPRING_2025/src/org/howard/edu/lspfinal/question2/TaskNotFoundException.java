// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Exception.html
package org.howard.edu.lspfinal.question2;

/**
 * Thrown when a requested task is not found in the system.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs a TaskNotFoundException with the specified detail message.
     *
     * @param message a description of the missing‐task error
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
