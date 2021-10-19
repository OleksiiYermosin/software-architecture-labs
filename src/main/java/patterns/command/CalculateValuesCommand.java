package patterns.command;

import mvc.interfaces.Model;
import mvc.interfaces.View;
import patterns.singleton.ValueInitializer;
import patterns.strategy.Operation;
import reflection.ComplexValue;

public class CalculateValuesCommand implements Command{
    private final Model model;

    private final View view;

    private Operation operation;

    public CalculateValuesCommand(Model model, View view, Operation operation) {
        this.model = model;
        this.view = view;
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String execute() {
        ValueInitializer initializer = ValueInitializer.getInstance(model, view);
        ComplexValue[] complexValues = initializer.initValues(2);
        return operation.performOperation(complexValues[0], complexValues[1]).toString();
    }
}
