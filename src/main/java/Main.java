package main.java;

import main.java.ui.CommandParser;
import main.java.ui.TaskService;
import main.java.ui.ui;


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
