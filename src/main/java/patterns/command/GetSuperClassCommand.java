package patterns.command;

import mvc.interfaces.Model;

public class GetSuperClassCommand implements Command{

    private final Model model;

    public GetSuperClassCommand(Model model) {
        this.model = model;
    }

    @Override
    public String execute() {
        return model.getSuperClassSimpleName();
    }
}
