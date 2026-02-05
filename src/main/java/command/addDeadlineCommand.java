package command;

import model.Deadline;
import ui.TaskService;
import ui.ui;

public class addDeadlineCommand implements Command {
    private TaskService taskService;
    private Deadline deadline;
    private ui ui;
    private String description;

    public addDeadlineCommand(TaskService taskService, ui ui, String description) {
        this.taskService = taskService;
        this.ui = ui;
        this.description = description;
        this.deadline = null;
    }

    @Override
    public void execute() {
        if (!description.contains("/by")) {
            ui.showMessage("Deadline requires '/by' parameter");
            return;
        }

        String[] split = description.split("/by", 2);
        String name = split[0].trim();
        String date = split[1].trim();

        if (name.isEmpty()) {
            ui.showMessage("Deadline description is empty");
            return;
        }
        if (date.isEmpty()) {
            ui.showMessage("Deadline is empty");
            return;
        }
        deadline = new Deadline(name, date);
        taskService.addTask(deadline);
        ui.showTaskAdded(deadline, taskService.getCounter());
    }

    @Override
    public boolean isExit() {
        return false;
    }



}
