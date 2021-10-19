package patterns.factory;

import reflection.ComplexValue;
import reflection.ComplexValueInterface;
import reflection.ExponentialComplexValue;

public class ValueFactory {

    public static ComplexValueInterface createValue(String type, double real, double imaginary) {
        ComplexValueInterface value;
        switch (type) {
            case "complex value":
                value = new ComplexValue(real, imaginary);
                break;
            case "exponential value":
                value = new ExponentialComplexValue(real, imaginary);
                break;
            default:
                throw new RuntimeException("Not supported type");
        }
        return value;
    }

}
