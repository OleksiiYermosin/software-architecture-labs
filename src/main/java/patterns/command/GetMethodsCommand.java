package patterns.command;

import mvc.interfaces.Model;

public class GetMethodsCommand implements Command{

    private final Model model;

    public GetMethodsCommand(Model model) {
        this.model = model;
    }

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        model.getMethodInfo().forEach(s -> sb.append(s).append("\n"));
        return sb.toString();
    }

}
