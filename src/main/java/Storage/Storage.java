package Storage;

import model.Deadline;
import model.Task;
import model.Todo;
import model.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;



public class Storage {
    private final String filePath;
    private final String folderPath;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.folderPath = filePath.substring(0, filePath.lastIndexOf(File.separator));
    }

    public List<Task> load() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        File folder = new File(folderPath);

        try {
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
                return tasks;
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {

                String[] parts = line.split(" \\| ");
                Task task = null;
                switch (parts[0]) {
                case "T":
                    task = new Todo(parts[2]);
                    break;
                case "D":
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;
                }

                if (task != null) {
                    if (parts[1].equals("1")) {
                        task.markAsDone();
                    }
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return tasks;
    }

    public void save(List<Task> tasks) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.fileFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }
}
