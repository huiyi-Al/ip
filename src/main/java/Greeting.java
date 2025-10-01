package main.java;
import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        greet();
        boolean isRunning = true;
        while (isRunning) {
            String instruction = sc.nextLine();
            switch (instruction) {
                case "bye":
                    isRunning = false;
                    break;
                    default:
                        System.out.println(instruction);
            }
        }
        exit();
    }
    public static void greet(){
        System.out.println("Hello! I'm Luka\n" +
                "What can I do for you?");
    }
    public static void exit(){
        System.out.println("Bye.Hope to see you again soon!");
    }
}
