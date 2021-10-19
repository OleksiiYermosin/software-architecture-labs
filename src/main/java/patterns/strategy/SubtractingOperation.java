package patterns.strategy;

import mvc.interfaces.Model;
import reflection.ComplexValue;

public class SubtractingOperation implements Operation{

    private final Model model;

    public SubtractingOperation(Model model) {
        this.model = model;
    }

    @Override
    public ComplexValue performOperation(ComplexValue firstValue, ComplexValue secondValue) {
        return model.subtractValues(firstValue, secondValue);
    }

}
