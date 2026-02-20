package command;

import ui.ui;
import ui.TaskService;

public class FindCommand implements Command{
    private TaskService taskService;
    private ui ui;
    private String taskNames;

    public FindCommand(TaskService taskService, ui ui, String taskNames) {
        this.taskService = taskService;
        this.ui = ui;
        this.taskNames = taskNames;
    }

    @Override
    public void execute() {
        if (taskNames.isEmpty()){
            ui.showMessage("Please enter a task name");
        }
        ui.findTask(taskService.searchTask(taskNames));
    }

    @Override
    public boolean isExit(){
        return false;
    }

}
