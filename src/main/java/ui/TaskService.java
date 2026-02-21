package ui;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import Storage.Storage;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int counter = 0;
    private Storage storage;

    public TaskService(Storage storage) {
        this.storage = storage;
        loadTasks();
    }

    private void loadTasks() {
        List<Task> loadedTasks = storage.load();
        for (Task task : loadedTasks) {
            tasks.add(task);
            counter++;
        }
    }

    private void saveTasks() {
        storage.save(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

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
