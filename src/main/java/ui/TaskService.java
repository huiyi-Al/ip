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
        tasks.addAll(loadedTasks);
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
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        counter--;
    }

    public void markTask(int index) {
        tasks.get(index).markAsDone();
    }

    public void unmarkTask(int index) {
        tasks.get(index).unmarkAsDone();
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
