package patterns.command;

public class ExitCommand implements Command{
    @Override
    public String execute() {
        System.exit(0);
        return "";
    }
}
