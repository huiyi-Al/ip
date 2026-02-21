import java.io.File;

import Storage.Storage;
import ui.commandParser;
import ui.TaskService;
import ui.ui;

public class Fressia {
    public static void main(String[] args) {
        String filePath = "data" + File.separator + "fressia.txt";
        Storage storage = new Storage(filePath);

        TaskService taskService = new TaskService(storage);

        ui ui = new ui();
        commandParser parser = new commandParser(ui, taskService);

        ui.greet();
        parser.run();
    }
}
