package main.java.command;

import main.java.model.Todo;
import main.java.ui.TaskService;
import main.java.ui.ui;

public class AddTodoCommand implements Command {
    private TaskService taskService;
    private ui ui;
    private String arguments;

    public AddTodoCommand(TaskService taskService, ui ui, String arguments) {
        this.taskService = taskService;
        this.ui = ui;
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (arguments.isEmpty()) {
            ui.showError("The description of a todo cannot be empty");
        }
        Todo todo = new Todo(arguments);
        taskService.addTask(todo);
        ui.showTaskAdded(todo, taskService.getTaskCount());
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
