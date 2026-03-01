package ui;

import javafx.scene.control.TextArea;
import model.Task;
import java.util.List;
import Javafx.MainWindow;

public class GuiUi extends ui {
    private MainWindow mainWindow; // Reference to MainWindow for dialog boxes

    public GuiUi(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void greet() {
        String message = "Hello, I'm Fressia\nWhat can I do for you?";
        mainWindow.showFressiaMessage(message);
    }

    @Override
    public String exit() {
        String message = "Bye. Hope to see you again soon !";
        mainWindow.showFressiaMessage(message);
        return message;
    }

    @Override
    public String readCommand() {
        // GUI doesn't use console input, so this can return empty
        // The command is handled through the text field instead
        return "";
    }

    @Override
    public void errorInput1() {
        String message = "Sorry, I don't understand what you want.";
        mainWindow.showFressiaMessage(message);
    }

    @Override
    public void showTaskAdded(Task task, int taskcount) {
        String message = "Got it. I've added this task: \n" + task +
                "\nNow you have " + taskcount + " tasks in the list";
        mainWindow.showFressiaMessage(message);
    }

    @Override
    public void showTaskdeleted(Task task, int taskcount) {
        String message = "Got it. I've removed this task: \n" + task +
                "\nNow you have " + taskcount + " tasks in the list";
        mainWindow.showFressiaMessage(message);
    }

    @Override
    public void showTaskList(List<Task> taskList) {
        if (taskList.isEmpty()) {
            String message = "There is no task yet";
            mainWindow.showFressiaMessage(message);
        } else {
            StringBuilder taskListMessage = new StringBuilder("Here are the tasks in the list:\n");
            for (int i = 1; i <= taskList.size(); i++) {
                String taskLine = i + "." + taskList.get(i - 1);
                taskListMessage.append(taskLine).append("\n");
            }
            mainWindow.showFressiaMessage(taskListMessage.toString());
        }
    }

    @Override
    public void findTask(List<Task> taskList) {
        if (taskList.isEmpty()) {
            String message = "There is no task match";
            mainWindow.showFressiaMessage(message);
        } else {
            StringBuilder findMessage = new StringBuilder("Here are the matching tasks in your list:\n");
            for (int i = 1; i <= taskList.size(); i++) {
                String taskLine = i + "." + taskList.get(i - 1);
                findMessage.append(taskLine).append("\n");
            }
            mainWindow.showFressiaMessage(findMessage.toString());
        }
    }

    @Override
    public void showMessage(String message) {
        mainWindow.showFressiaMessage(message);
    }

    @Override
    public void invalidTask() {
        String message = "Invalid task number!";
        mainWindow.showFressiaMessage(message);
    }

    @Override
    public void invalidTimeFormatter() {
        String message = "Invalid time format!";
        mainWindow.showFressiaMessage(message);
    }
}
