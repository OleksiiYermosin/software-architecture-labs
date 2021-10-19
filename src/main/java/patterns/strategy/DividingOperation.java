package patterns.strategy;

import mvc.interfaces.Model;
import reflection.ComplexValue;

public class DividingOperation implements Operation{

    private final Model model;

    public DividingOperation(Model model) {
        this.model = model;
    }

    @Override
    public ComplexValue performOperation(ComplexValue firstValue, ComplexValue secondValue) {
        return model.divideValues(firstValue, secondValue);
    }

}
