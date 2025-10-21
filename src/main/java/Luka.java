package main.java;

import main.java.ui.CommandParser;
import main.java.ui.TaskService;
import main.java.ui.ui;


/**
 * The main entry point of the robot
 * With greeting and exiting functions
 */
public class Luka {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        ui ui = new ui();
        CommandParser parser = new CommandParser(taskService, ui);

        ui.greet();
        parser.run();
        ui.exit();
    }
}