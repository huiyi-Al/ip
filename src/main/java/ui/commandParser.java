package ui;

import command.addEventCommand;
import command.addDeadlineCommand;
import command.addTodoCommand;
import command.Command;
import command.ExitCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;

public class commandParser {
    private ui ui;
    private TaskService taskService;

    public commandParser(ui ui, TaskService taskService) {
        this.ui = ui;
        this.taskService = taskService;
    }

    public void run(){
        boolean isRunning = true;
        while(isRunning) {
            String input = ui.readCommand();
            Command command = parseCommand(input);

            if(command != null) {
                command.execute();
                if (command.isExit()) {
                    isRunning = false;
                }
            } else {
                ui.errorInput1();
            }
        }
    }

    public Command parseCommand(String input) {
        String[] command = input.split(" ", 2);
        String commandName = command[0];
        String arguments = " ";
        if (command.length > 1) {
            arguments = command[1];
        }
        switch (commandName) {
        case "bye":
            return new ExitCommand(ui);
        case "list":
            return new ListCommand(taskService, ui);
        case "mark":
            return new MarkCommand(taskService, ui, arguments);
        case "unmark":
            return new UnmarkCommand(taskService, ui, arguments);
        case "todo":
            return new addTodoCommand(taskService, ui, arguments);
        case "deadline":
            return new addDeadlineCommand(taskService, ui, arguments);
        case "event":
            return new addEventCommand(taskService, ui, arguments);
        default:
            return null;
        }
    }
}
