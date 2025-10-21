package main.java.command;

import main.java.ui.TaskService;
import main.java.ui.ui;

public class DeleteCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;

    public DeleteCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        try{
            int taskId = Integer.parseInt(arguments) - 1;
            taskService.removeTask(taskId);
            ui.showTaskDeleted(taskService.getTask(taskId), taskService.getTaskCount());
        } catch (Exception e) {
            ui.showError("Invalid task number!");
        }
    }
    @Override
    public boolean isExit(){
        return false;
    }

}
