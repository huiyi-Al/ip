import ui.commandParser;
import ui.TaskService;
import ui.ui;

public class Fressia {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        ui ui = new ui();
        commandParser parser = new commandParser(ui, taskService);

        ui.greet();
        parser.run();
    }
}
