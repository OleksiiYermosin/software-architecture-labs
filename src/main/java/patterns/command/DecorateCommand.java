package patterns.command;

import mvc.interfaces.Model;
import mvc.interfaces.View;
import patterns.singleton.ValueInitializer;
import reflection.ComplexValue;

public class DecorateCommand implements Command{

    private final Model model;

    private final View view;

    public DecorateCommand(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public String execute() {
        ValueInitializer initializer = ValueInitializer.getInstance(model, view);
        ComplexValue[] complexValues = initializer.initValues(1);
        return complexValues[0].toString();
    }

}
