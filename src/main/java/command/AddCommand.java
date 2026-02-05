//package command;
//
//import model.Task;
//import ui.TaskService;
//import ui.ui;
//
//public class AddCommand implements Command {
//    private TaskService taskService;
//    private ui ui;
//    private String description;
//
//    public AddCommand(TaskService taskService, ui ui, String description) {
//        this.taskService = taskService;
//        this.ui = ui;
//        this.description = description;
//    }
//
//    @Override
//    public void execute() {
//        Task task = new Task(description);
//        taskService.addTask(task);
//        ui.showTaskAdded(task);
//    }
//
//    @Override
//    public boolean isExit() {
//        return false;
//    }
//
//}
