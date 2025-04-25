// https://www.onlinegdb.com

package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a unique name, integer priority (lower = higher),
 * and one of three statuses: "TODO", "IN_PROGRESS", or "DONE".
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Constructs a new Task.
     *
     * @param name     unique task name
     * @param priority integer priority (lower number = higher priority)
     * @param status   initial status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name     = name;
        this.priority = priority;
        this.status   = status;
    }

    /** @return the unique name of this task */
    public String getName() {
        return name;
    }

    /** @return the integer priority of this task */
    public int getPriority() {
        return priority;
    }

    /** @return the current status of this task */
    public String getStatus() {
        return status;
    }

    /**
     * Updates this task’s status.
     * @param status new status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
