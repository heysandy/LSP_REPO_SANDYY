// https://www.baeldung.com/java


package org.howard.edu.lspfinal.question2;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of uniquely-named Tasks. Supports adding,
 * lookup by name, status updates, and printing tasks grouped by status.
 */
public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task. Names must be unique.
     *
     * @param name     unique task name
     * @param priority integer priority (lower = higher)
     * @param status   initial status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws DuplicateTaskException if a task with this name already exists
     */
    public void addTask(String name, int priority, String status)
            throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its unique name.
     *
     * @param name name of the task to retrieve
     * @return the Task instance
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return t;
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name   the name of the task to update
     * @param status new status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task t = getTaskByName(name);
        t.setStatus(status);
    }

    /**
     * Prints all tasks to stdout, grouped under TODO, IN_PROGRESS, and DONE.
     * Groups appear in that order.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        String[] statuses = { "TODO", "IN_PROGRESS", "DONE" };
        for (String st : statuses) {
            System.out.println(st + ":");
            for (Task t : tasks.values()) {
                if (st.equals(t.getStatus())) {
                    System.out.println("  " + t);
                }
            }
        }
    }
}
