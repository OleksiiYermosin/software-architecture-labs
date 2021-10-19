package patterns.strategy;

import reflection.ComplexValue;

public interface Operation {

    ComplexValue performOperation(ComplexValue firstValue, ComplexValue secondValue);

}
