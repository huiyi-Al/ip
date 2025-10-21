package main.java.command;

import java.time.LocalDate;

import main.java.model.Deadline;
import main.java.ui.DateTimeService;
import main.java.ui.TaskService;
import main.java.ui.ui;

/**
 * Add command to support user add a task with specific deadline
 */
public class AddDeadlineCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;
    private DateTimeService dateTimeService;

    public AddDeadlineCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
        this.dateTimeService = dateTimeService;
    }

    @Override
    public void execute() {
        if (!arguments.contains("/by")) {
            ui.showError("Deadline requires '/by' parameter");
            return;
        }

        String[] parts = arguments.split("/by", 2);
        String description = parts[0].trim();
        String date = parts[1].trim();

        if (description.isEmpty()) {
            ui.showError("Deadline description is empty");
            return;
        }

        String datetime = dateTimeService.outputDateTime(date);
        Deadline deadline = new Deadline(description, datetime);
        taskService.addTask(deadline);
        ui.showTaskAdded(deadline, taskService.getTaskCount());
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
