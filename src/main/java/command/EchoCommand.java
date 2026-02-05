package command;

public class EchoCommand implements Command {
    private String input;

    public EchoCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute() {
        System.out.println(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
