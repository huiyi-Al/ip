package ui;

import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int counter = 0;

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
}
