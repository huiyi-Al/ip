package command;

import ui.ui;

public class ExitCommand implements Command {
    private ui ui;

    public ExitCommand(ui ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        System.out.println(ui.exit());
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
