package main.java;
import java.util.ArrayList;

abstract class Task{
    public String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public void unmark(){
        this.isDone = false;
    }
    public String getStatus(){
        return (isDone ? "[x]" : "[]");
    }
    public String getStatusNumber(){
        return (isDone ? "1" : "0");
    }
    public abstract String getType();
    public abstract String toFileString();

    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description;
    }
}
class Todo extends Task{
    public Todo(String description){
        super(description);
    }
    @Override
    public String getType() {
        return "T";
    }
    @Override
    public String toFileString() {
        return "T | " + getStatus() + " | " + description;
    }
}
class Deadline extends Task{
    private String deadline;

    public Deadline(String description, String deadline){
        super(description);
        this.deadline = deadline;
    }
    @Override
    public String getType() {
        return "D";
    }
    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description + " (by: " + deadline + ")";
    }
    @Override
    public String toFileString() {
        return "D | " + getStatus() + " | " + description + " | " + deadline;
    }
}
class Event extends Task{
    private String start;
    private String end;

    public Event(String description, String start, String end){
        super(description);
        this.start = start;
        this.end = end;
    }
    @Override
    public String getType() {
        return "E";
    }
    @Override
    public String toString() {
        return "[" + getType() + "]" + getStatus() + " " + description + " (from: " + start + " to: " + end + ")";
    }
    @Override
    public String toFileString() {
        return "E | " + getStatus() + " | " + description + " | " + start + "-" + end;
    }
}
public class TaskList{
    private ArrayList<Task> tasks;
    private static int counter;

    public TaskList(ArrayList<Task> tasks){
        this.tasks = new ArrayList<Task>();
        this.counter = 0;
    }
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    public static int getCounter(){
        return counter;
    }
    public void addTask(Task task){
        tasks.add(task);
        counter++;
        Storage.saveTasks(tasks);
    }
    public void markTask(int taskNumber){
        Task task = tasks.get(taskNumber - 1);
        task.markAsDone();
        Storage.saveTasks(tasks);
    }
    public void unmarkTask(int taskNumber){
        Task task = tasks.get(taskNumber - 1);
        task.unmark();
        Storage.saveTasks(tasks);
    }
    public void deleteTask(int taskNumber){
        Task Taskremove = tasks.remove(taskNumber - 1);
        counter--;
        Storage.saveTasks(tasks);
    }
    public Task getTask(int taskNumber){
        return tasks.get(taskNumber - 1);
    }
}