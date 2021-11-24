package patterns.command;

import patterns.singleton.ValueInitializer;
import patterns.strategy.Operation;
import reflection.ComplexValue;
import spring.contexts.JavaContext;


public class CalculateValuesCommand implements Command{

    private Operation operation;

    public CalculateValuesCommand() {
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String execute() {
        ValueInitializer initializer = JavaContext.getBean("valueInitializer", ValueInitializer.class);
        ComplexValue[] complexValues = initializer.initValues(2);
        return operation.performOperation(complexValues[0], complexValues[1]).toString();
    }

}
