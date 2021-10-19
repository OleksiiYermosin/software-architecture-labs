package patterns.command;

import mvc.interfaces.Model;

public class InvokeMethodsCommand implements Command{

    private final Model model;

    public InvokeMethodsCommand(Model model) {
        this.model = model;
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        model.invokeAnnotatedMethods().forEach(s -> sb.append(s).append("\n"));
        return sb.toString();
    }

}
