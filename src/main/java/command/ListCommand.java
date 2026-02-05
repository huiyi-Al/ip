package command;

import ui.TaskService;
import ui.ui;

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
