package ui;

import java.util.Scanner;
import java.util.List;

import model.Task;

public class ui {

    Scanner sc = new Scanner(System.in);

    /**
     * Shows greeting message
     */
    public void greet() {
        System.out.println("Hello, I'm Fressia\n" +
                "What can I do for you?");
    }

    /**
     * Shows exit message
     */
    public String exit() {
        return "Bye. Hope to see you again soon !";
    }

    /**
     * Reads the input command
     * @return command
     */
    public String readCommand() {
        System.out.println(">");
        return sc.nextLine();
    }

    public void errorInput1() {
        System.out.println("Sorry, I don't understand what you want.");
    }

    public void showTaskAdded(Task task, int taskcount) {
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.println("Now you have " + taskcount + " tasks in the list");
    }

    public void showTaskdeleted(Task task, int taskcount) {
        System.out.println("Got it. I've removed this task: \n" + task);
        System.out.println("Now you have " + taskcount + " tasks in the list");
    }

    public void showTaskList(List<Task> taskList) {
        if(taskList.isEmpty()) {
            System.out.println("There is no task yet");
        } else {
            System.out.println("Here are the tasks in the list:");
            for (int i = 1; i <= taskList.size(); i++) {
                System.out.println(i + "." + taskList.get(i - 1));
            }
        }
    }

    public void showMessage (String message) {
        System.out.println(message);
    }

    public void invalidTask() {
        System.out.println("Invalid task number!");
    }

    public void invalidTimeFormatter(){

    }
}
