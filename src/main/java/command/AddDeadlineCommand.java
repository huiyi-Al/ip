package main.java.command;

import java.time.LocalDate;

import main.java.model.Deadline;
import main.java.ui.DateTimeService;
import main.java.ui.TaskService;
import main.java.ui.ui;


public class AddDeadlineCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;
    private DateTimeService dateTimeService;

    public AddDeadlineCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
        this.dateTimeService = new DateTimeService();
    }

    @Override
    public void execute() {
        if (!arguments.contains("/by")) {
            ui.showError("Deadline requires '/by' parameter");
            return;
        }

        String[] parts = arguments.split("/by", 2);
        String description = parts[0];
        String date = parts[1];

        if (description.isEmpty()) {
            ui.showError("Deadline description is empty");
            return;
        }

        LocalDate by = dateTimeService.parseDate(date);
        Deadline deadline = new Deadline(description, by);
        taskService.addTask(deadline);
        ui.showTaskAdded(deadline, taskService.getTaskCount());
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
