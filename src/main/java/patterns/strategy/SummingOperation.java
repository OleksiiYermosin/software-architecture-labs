package patterns.strategy;

import mvc.interfaces.Model;
import reflection.ComplexValue;

public class SummingOperation implements Operation{

    private final Model model;

    public SummingOperation(Model model) {
        this.model = model;
    }

    @Override
    public ComplexValue performOperation(ComplexValue firstValue, ComplexValue secondValue) {
        return model.addValues(firstValue, secondValue);
    }
}
