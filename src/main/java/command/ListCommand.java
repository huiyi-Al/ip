package command;

import ui.TaskService;
import ui.ui;

/**
 * Lists all tasks stored in the system with their type,description and status in the order they were added.
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
        ui.showTaskList(taskService.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
