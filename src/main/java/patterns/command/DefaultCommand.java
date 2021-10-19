package patterns.command;

public class DefaultCommand implements Command{
    @Override
    public String execute() {
        return "Unknown command, try again.";
    }
}
