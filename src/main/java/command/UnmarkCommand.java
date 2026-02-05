package command;

import ui.TaskService;
import ui.ui;


public class UnmarkCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String argument;
    private int taskId;

    public UnmarkCommand(TaskService taskService, ui ui, String argument) {
        this.taskService = taskService;
        this.ui = ui;
        this.argument = argument;
        this.taskId= 0;
    }

    @Override
    public void execute() {
        try {
            taskId = Integer.parseInt(argument) - 1;
            if (taskService.getTask(taskId).getStatus().equals("[ ]")) {
                System.out.println("This task is already unmarked");
            } else {
                taskService.unmarkTask(taskId);
                ui.showMessage("Ok, I will unmark this task:\n" +
                        taskService.getTask(taskId).toString());
            }
        } catch ( Exception e ) {
            ui.invalidTask();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
