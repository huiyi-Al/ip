package command;

import ui.TaskService;
import ui.ui;


public class MarkCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;
    private int taskId;

    public MarkCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
        this.taskId = 0;
    }

    @Override
    public void execute() {
        try {
            taskId = Integer.parseInt(arguments) - 1;
            if (taskService.getTask(taskId).getStatus().equals("[X]")) {
                System.out.println("This task is already marked");
            } else {
                taskService.markTask(taskId);
                ui.showMessage("Nice! I've mared this as done:\n " +
                        taskService.getTask(taskId).toString());
            }
        } catch (Exception e) {
            ui.invalidTask();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
