package main.java.ui;

import java.util.Scanner;

import main.java.model.Task;

public class ui {
    private static Scanner sc = new Scanner(System.in);

    public void greet() {
        System.out.println("Hello! I'm Luka\n" +
                "What can I do for you?");
    }

    public static void exit() {
        System.out.println("Bye.Hope to see you again soon!");
        sc.close();
    }

    public String readcommand() {
        return sc.nextLine();
    }

    public void showError(String massage) {
        System.out.println("OPPS!! " + massage);
    }

    public void showMassage(String massage) {
        System.out.println(massage);
    }

    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.println("Now you have" + totalTasks + "tasks in the list");
    }

    public void showTaskDeleted(Task task, int totalTasks) {
        System.out.println("Noted. I've removed this task: \n" + task);
        System.out.println("Now you have" + totalTasks + "tasks in the list");
    }

    public void showListTask(java.util.List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }
}
