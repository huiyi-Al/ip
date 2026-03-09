package command;

import ui.ui;

/**
 * Exits the system and terminate the running process.
 */
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
