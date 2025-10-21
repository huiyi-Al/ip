package main.java.command;

import main.java.ui.TaskService;
import main.java.ui.ui;

/**
 * Add command for user to mark Task in a specific index as not done
 */
public class UnmarkCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;

    public UnmarkCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        try{
            int taskId = Integer.parseInt(arguments) - 1;
            taskService.unmarkTasks(taskId);
            ui.showMassage("OK, I've marked this task as not done yet: \n" +
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
