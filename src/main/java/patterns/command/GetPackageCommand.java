package patterns.command;

import mvc.interfaces.Model;

public class GetPackageCommand implements Command{

    private final Model model;

    public GetPackageCommand(Model model) {
        this.model = model;
    }

    @Override
    public String execute() {
        return model.getPackageName();
    }

}
