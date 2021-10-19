package patterns.command;

import mvc.interfaces.Model;
import mvc.interfaces.View;
import patterns.decorator.RoundedDecorator;
import patterns.singleton.ValueInitializer;
import reflection.ComplexValue;
import reflection.ComplexValueInterface;

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
        ComplexValueInterface decorator = new RoundedDecorator(initializer.initValues(1)[0]);
        return decorator.toString();
    }

}
