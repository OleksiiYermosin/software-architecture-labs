package patterns.strategy;

import mvc.interfaces.Model;
import reflection.ComplexValue;

public class MultiplyingOperation implements Operation{

    private final Model model;

    public MultiplyingOperation(Model model) {
        this.model = model;
    }

    @Override
    public ComplexValue performOperation(ComplexValue firstValue, ComplexValue secondValue) {
        return model.multiplyValues(firstValue, secondValue);
    }

}
