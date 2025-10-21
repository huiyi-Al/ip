package main.java.command;

import main.java.ui.TaskService;
import main.java.ui.ui;

/**
 * Add command support finding task with a description
 */
public class FindCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;

    public FindCommand(TaskService taskService, ui ui, String arguments){
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (arguments.isEmpty()){
            ui.showError("Please enter a task");
        }
        ui.showMatchingTask(taskService.searchTask(arguments));
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
