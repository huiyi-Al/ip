package main.java.ui;

import main.java.command.AddDeadlineCommand;
import main.java.command.AddEventCommand;
import main.java.command.AddTodoCommand;
import main.java.command.Command;
import main.java.command.DeleteCommand;
import main.java.command.ExitCommand;
import main.java.command.ListCommand;
import main.java.command.MarkCommand;
import main.java.command.UnmarkCommand;

/**
 * Parser a command input by user and process
 */
public class CommandParser {
    private TaskService service;
    private ui ui;

    /**
     * Constructs a commandparser with task service and ui
     *
     * @param service  The taskservice that dealing with task operation
     * @param ui       The ui part that out print messages
     */
    public CommandParser(TaskService service, ui ui) {
        this.service = service;
        this.ui = ui;
    }

    /**
     * Process and run the command
     */
    public void run(){
        boolean isRunning = true;
        while(isRunning){
            String input = ui.readcommand();
            Command command = parseCommand(input);

            if(command != null){
                command.execute();
                if (command.isExit()){
                    isRunning = false;
                }
            }else{
                ui.showError("I'm sorry, but I don't know what that means :-(");
            }
        }
    }

    /**
     * Read the input command
     *
     * @param input  The command user inputted
     * @return A specific command
     */
    public Command parseCommand(String input){
        String[] parts = input.split(" ");
        String commandWord = parts[0];
        String arguments = "";
        if (parts.length > 1){
             arguments = parts[1];
        }
        switch (commandWord) {
            case "bye":
                return new ExitCommand(ui);
            case "list":
                return new ListCommand(service, ui);
            case "mark":
                return new MarkCommand(service, ui, arguments);
            case "unmark":
                return new UnmarkCommand(service, ui, arguments);
            case "todo":
                return new AddTodoCommand(service, ui, arguments);
            case "deadline":
                return new AddDeadlineCommand(service, ui, arguments);
            case "event":
                return new AddEventCommand(service, ui, arguments);
            case "delete":
                return new DeleteCommand(service, ui, arguments);
            default:
                return null;
        }
    }
}
