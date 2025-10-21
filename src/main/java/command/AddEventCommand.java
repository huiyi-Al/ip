package main.java.command;

import java.time.LocalDateTime;

import main.java.model.Event;
import main.java.ui.DateTimeService;
import main.java.ui.TaskService;
import main.java.ui.ui;


public class AddEventCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;
    private DateTimeService dateTimeService;

    public AddEventCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
        this.dateTimeService = new DateTimeService();
    }

    @Override
    public void execute() {
        if (!arguments.contains("/from") || !arguments.contains("/to")) {
            ui.showError("Deadline requires '/from' and '/to' parameter");
            return;
        }

        String[] parts = arguments.split(" /from | /to");

        if (parts.length != 3) {
            ui.showError("Invalid event format!");
            return;
        }

        String description = parts[0];
        String fromstring = parts[1];
        String tostring = parts[2];

        if (description.isEmpty()) {
            ui.showError("Description cannot be empty!");
        }

        LocalDateTime from = dateTimeService.parseDateTime(fromstring);
        LocalDateTime to = dateTimeService.parseDateTime(tostring);

        Event event = new Event(description, from, to);
        taskService.addTask(event);
        ui.showTaskAdded(event, taskService.getTaskCount());
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
