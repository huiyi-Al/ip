package main.java;

import main.java.ui.TaskService;
import main.java.ui.ui;
import main.java.ui.CommandParser;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        ui ui = new ui();
        CommandParser parser = new CommandParser(taskService, ui);

        ui.greet();
        parser.run();
        ui.exit();
    }
}
