package main.java;

import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static final String PATH = "./data/luka.txt";

    public static ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try{
            Path path = Paths.get(PATH);
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                return tasks;
            }
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(path));
            for (String line : lines) {
                Task task = taskFromString(line);
                tasks.add(task);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tasks;
    }

    public static void saveTasks(ArrayList<Task> tasks) {
        try{
            Path path = Paths.get(PATH);
            Files.createDirectories(path.getParent());

            FileWriter fw = new FileWriter(PATH);
            for (Task task : tasks) {
                fw.write(task.toFileString() + "\n");
            }
            fw.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
    private static Task taskFromString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 3) return null;

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task = null;
        switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                if (parts.length >= 4){
                    task = new Deadline(description, parts[3]);
                }
                break;
            case "E":
                if (parts.length >= 5){
                    task = new Event(description, parts[3], parts[4]);
                }
                break;
            default:
                return null;
        }

        if (isDone){
            task.markAsDone();
        }
        return task;
    }

}
