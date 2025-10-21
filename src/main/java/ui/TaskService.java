package main.java.ui;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Task;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int counter = 0;

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks.get(index);
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

    public void addTask(Task task) {
        tasks.add(task);
        counter++;
    }

    public Task removeTask(int index) {
        counter--;
        return tasks.remove(index);
    }

    public int getTaskCount() {
        return counter;
    }

    public void markTask(int index) {
        tasks.get(index).markAsDone();
    }

    public void unmarkTasks(int index) {
        tasks.get(index).unmark();
    }
}
