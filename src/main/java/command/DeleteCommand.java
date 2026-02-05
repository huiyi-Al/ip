package command;

import model.Task;
import ui.TaskService;
import ui.ui;

public class DeleteCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String argument;
    private int taskId;
    private Task task;

    public DeleteCommand(TaskService taskService, ui ui, String argument) {
        this.taskService = taskService;
        this.ui = ui;
        this.argument = argument;
        this.taskId = 0;
        this.task = null;
    }

    @Override
    public void execute() {
        try {
            taskId = Integer.parseInt(argument) - 1;
            task = taskService.getTask(taskId);
            taskService.removeTask(task);
            ui.showTaskdeleted(task, taskService.getCounter());
        } catch (Exception e) {
            ui.invalidTask();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
