package main.java.command;

import main.java.ui.ui;

public class ExitCommand implements Command {
    private ui ui;

    public ExitCommand(ui ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isExit(){
        return true;
    }
}
