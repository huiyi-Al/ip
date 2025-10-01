package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class Greeting {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<Task>();
    private static int counter = 0;

    public static void main(String[] args) {
        greet();

        boolean isRunning = true;
        while (isRunning) {
            String instruction = sc.nextLine();

            if (instruction.equals("bye")) {
                isRunning = false;
            } else if (instruction.equals("list")) {
                listTask();
            } else if (instruction.startsWith("mark")) {
                markTask(instruction);
            } else if (instruction.startsWith("unmark")) {
                unmarkTask(instruction);
            } else if (instruction.startsWith("todo")) {
                addTodoTask(instruction);
            } else if (instruction.startsWith("deadline")) {
                addDeadlineTask(instruction);
            } else if (instruction.startsWith("event")) {
                addEventTask(instruction);
            } else if (instruction.startsWith("delete")) {
                deleteTask(instruction);
            } else {
                System.out.println("OOPS!! I'm sorry, but I don't know what that means :-(");
            }
        }
        exit();
        sc.close();
    }
    public static void greet(){
        System.out.println("Hello! I'm Luka\n" +
                "What can I do for you?");
    }
    public static void exit(){
        System.out.println("Bye.Hope to see you again soon!");
    }
    public static void listTask(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }
    public static void markTask(String task){
        String[] input = task.split(" ");
        int order = Integer.parseInt(input[1]);
        Task taskToMark = tasks.get(order - 1);
        taskToMark.markAsDone();
        System.out.println("Nice ! I've marked this task as done: \n" + taskToMark);
    }
    public static void unmarkTask(String task){
        String[] input = task.split(" ");
        int order = Integer.parseInt(input[1]);
        Task taskToUnmark = tasks.get(order - 1);
        taskToUnmark.unmark();
        System.out.println("OK, I've marked this task as not done yet: \n" + taskToUnmark);
    }
    public static void addTodoTask(String task){
        String[] input = task.split(" ", 2);
        if(input.length < 2){
            System.out.println("OOPS!!! The description of a todo cannot be empty");
            return;
        }
        String taskToAdd = input[1];
        Task newTask = new Todo(taskToAdd);
        tasks.add(newTask);
        counter++;
        System.out.println("Got it. I've added this task: \n" + newTask);
        System.out.println("Now you have " + counter + " tasks in the list");
    }
    public static void addDeadlineTask(String task){
        String[] input = task.split(" /");
        String[] Date = input[1].split(" ");
        String[] Activity = input[0].split(" ", 2);
        String act = Activity[1];
        String date = Date[1];
        Task newTask = new Deadline(act, date);
        tasks.add(newTask);
        counter ++;
        System.out.println("Got it. I've added this task: \n" + newTask);
        System.out.println("Now you have " + counter + " tasks in the list");
    }
    public static void addEventTask(String task){
        if(!tasks.contains("/from") || !tasks.contains("/to")){
            System.out.println("OOPS!!! Event date missing.");
            return;
        }
        String[] input = task.split(" /");
        String[] Activity = input[0].split(" ", 2);
        String act = Activity[1];
        String[] time1 = input[1].split(" ", 2);
        String start = time1[1];
        String[] time2 = input[2].split(" ", 2);
        String end = time2[1];
        Task newTask = new Event(act, start, end);
        tasks.add(newTask);
        counter ++;
        System.out.println("Got it. I've added this task: \n" + newTask);
        System.out.println("Now you have " + counter + " tasks in the list");
    }
    public static void deleteTask(String task){
        String[] input = task.split(" ");
        int order = Integer.parseInt(input[1]);
        Task taskToDelete = tasks.get(order - 1);
        tasks.remove(taskToDelete);
        counter --;
        System.out.println("Noted. I've removed this task: \n" + taskToDelete);
        System.out.println("Now you have " + counter + " tasks in the list");
    }
}
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
    public abstract String getType();

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
}
