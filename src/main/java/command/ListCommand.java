package main.java.command;

import main.java.ui.TaskService;
import main.java.ui.ui;

/**
 * Add command to support user checking TaskList
 */
public class ListCommand implements Command {
    private TaskService taskService;
    private ui ui;

    public ListCommand(TaskService taskService, ui ui) {
        this.taskService = taskService;
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.showListTask(taskService.getTasks());
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
