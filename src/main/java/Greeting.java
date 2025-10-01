package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class Greeting {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<Task>();
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
            } else {
                addTask(instruction);
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
    public static void addTask(String task){
        Task newTask = new Task(task);
        tasks.add(newTask);
        System.out.println("added: " + task);
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
}
class Task{
    private String discription;
    private boolean isDone;

    public Task(String discription) {
        this.discription = discription;
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
    @Override
    public String toString() {
        return getStatus() + " " + discription;
    }
}
