package ui;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import Storage.Storage;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int counter = 0;
    private Storage storage;

    /**
     * Constructs a new TaskService with the specified storage mechanism.
     * Automatically loads existing tasks from storage upon initialization.
     *
     * @param storage The storage for use to save/load tasks
     */
    public TaskService(Storage storage) {
        this.storage = storage;
        loadTasks();
    }

    /**
     * Loads tasks from storage.
     * Updates the counter based on the number of loaded tasks.
     */
    private void loadTasks() {
        List<Task> loadedTasks = storage.load();
        for (Task task : loadedTasks) {
            tasks.add(task);
            counter++;
        }
    }

    /**
     * Saves all current tasks to persistent storage.
     */
    private void saveTasks() {
        storage.save(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Get task with specific index
     * @param index The zero-based position of the task in the list
     * @return      The task at the specified index
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
        counter++;
        saveTasks();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        counter--;
        saveTasks();
    }

    public void markTask(int index) {
        tasks.get(index).markAsDone();
        saveTasks();
    }

    public void unmarkTask(int index) {
        tasks.get(index).unmarkAsDone();
        saveTasks();
    }

    public int getCounter() {
        return counter;
    }

    /**
     * Searches for tasks that contain the specified text in their description.
     *
     * @param taskName The text to search for in task descriptions
     * @return List of tasks that contain the search text in their description
     */
    public List<Task> searchTask(String taskName) {
        List<Task> selectedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.description.contains(taskName)) {
                selectedTasks.add(task);
            }
        }
        return selectedTasks;
    }
}
