package main.java.command;

import main.java.ui.TaskService;
import main.java.ui.ui;

public class MarkCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;

    public MarkCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        try{
            int taskId = Integer.parseInt(arguments) - 1;
            taskService.markTask(taskId);
            ui.showMassage("Nice ! I've marked this task as done: \n" +
                    taskService.getTask(taskId));
        } catch (Exception e) {
            ui.showError("Invalid task number!");
        }
    }
    @Override
    public boolean isExit(){
        return false;
    }
}
