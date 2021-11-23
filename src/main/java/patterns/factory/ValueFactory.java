package patterns.factory;

import reflection.ComplexValue;
import reflection.ComplexValueInterface;
import reflection.ExponentialComplexValue;

public class ValueFactory {

    public static ComplexValueInterface createValue(String type) {
        ComplexValueInterface value;
        switch (type) {
            case "complex value":
                value = new ComplexValue();
                break;
            case "exponential value":
                value = new ExponentialComplexValue();
                break;
            default:
                throw new RuntimeException("Not supported type");
        }
        return value;
    }

}
