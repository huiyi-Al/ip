package command;

import model.Todo;
import ui.TaskService;
import ui.ui;

public class addTodoCommand implements Command{
    private TaskService taskService;
    private ui ui;
    private Todo todo;
    private String description;

    public addTodoCommand (TaskService taskService, ui ui, String description) {
        this.taskService = taskService;
        this.ui = ui;
        this.description = description;
        this.todo = null;
    }

    @Override
    public void execute() {
        if (description.isEmpty()) {
            ui.showMessage("The description cannot be empty");
            return;
        }

        todo = new Todo(description);
        taskService.addTask(todo);
        ui.showTaskAdded(todo, taskService.getCounter());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
