package Fressia;

import java.io.File;

import Storage.Storage;
import ui.commandParser;
import ui.TaskService;
import ui.ui;

public class Fressia {
    private Storage storage;
    private TaskService taskService;
    private ui ui;

    public Fressia() {
        String filePath = "data" + File.separator + "fressia.txt";
        this.storage = new Storage(filePath);
        this.taskService = new TaskService(storage);
        this.ui = new ui();
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public ui getUi() {
        return ui;
    }

    public static void main(String[] args) {
        Fressia fressia = new Fressia();

        commandParser parser = new commandParser(fressia.getUi(), fressia.getTaskService());

        fressia.getUi().greet();
        parser.run();
    }
}
