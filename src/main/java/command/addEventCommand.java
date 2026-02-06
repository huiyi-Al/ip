package command;

import model.Event;
import ui.DateTimeService;
import ui.TaskService;
import ui.ui;

public class addEventCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private Event event;
    private String description;
    private DateTimeService dateTimeService;

    public addEventCommand(TaskService taskService, ui ui, String description) {
        this.taskService = taskService;
        this.ui = ui;
        this.description = description;
        this.event = null;
        this.dateTimeService = new DateTimeService();
    }

    @Override
    public void execute() {
        if (!description.contains("/from") || !description.contains("/to")) {
            ui.showMessage("Event requires '/from' and '/to' parameters");
            return;
        }
        String[] split = description.split("/from | /to");
        String name = split[0];
        String start = split[1];
        String end = split[2];

        if (name.isEmpty()) {
            ui.showMessage("Event name cannot be empty!");
        }
        if (start.isEmpty()) {
            ui.showMessage("Please enter a valid start date.");
            return;
        }
        if (end.isEmpty()) {
            ui.showMessage("Please enter a valid end date.");
            return;
        }

        String startTime = dateTimeService.outputDateTime(start);
        String endTime = dateTimeService.outputDateTime(end);
        event = new Event(name, startTime, endTime);
        taskService.addTask(event);
        ui.showTaskAdded(event, taskService.getCounter());
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
