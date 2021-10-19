package patterns.command;

import mvc.interfaces.Model;

public class GetClassCommand implements Command{

    private final Model model;

    public GetClassCommand(Model model) {
        this.model = model;
    }

    @Override
    public String execute() {
        return model.getClassSimpleName();
    }

}
