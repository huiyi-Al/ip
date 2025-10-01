package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class Greeting {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> tasks = new ArrayList<String>();
    public static void main(String[] args) {
        greet();

        boolean isRunning = true;
        while (isRunning) {
            String instruction = sc.nextLine();

            switch (instruction) {
                case "bye":
                    isRunning = false;
                    break;
                case "list":
                    listTask();
                    break;
                default:
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
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }
    public static void addTask(String task){
        tasks.add(task);
        System.out.println("added: " + task);
    }
}
