package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExponentialComplexValueTest {

    @Test
    public void testTransformMethod(){
        ExponentialComplexValue expectedValue = new ExponentialComplexValue(-2, 1);
        ExponentialComplexValue actualValue = ExponentialComplexValue.transformComplexValue(
                new ComplexValue(expectedValue.getReal(), expectedValue.getImaginary()));
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testHashFunction(){
        ExponentialComplexValue firstValue = new ExponentialComplexValue(-2, 1);
        ExponentialComplexValue secondValue = new ExponentialComplexValue(-2, 1);
        Assertions.assertEquals(firstValue.hashCode(), secondValue.hashCode());
        secondValue.setModule(3);
        Assertions.assertNotEquals(firstValue.hashCode(), secondValue.hashCode());
    }

    @Test
    public void testEqualsMethod(){
        ExponentialComplexValue firstValue = new ExponentialComplexValue(-2, 1);
        ExponentialComplexValue secondValue = new ExponentialComplexValue(-2, 1);
        Assertions.assertEquals(firstValue, firstValue);
        Assertions.assertNotEquals(null, firstValue);
        Assertions.assertEquals(firstValue, secondValue);
    }

    @Test
    public void testEqualsMethodWithDifferentInstance(){
        ExponentialComplexValue firstValue = new ExponentialComplexValue(-2, 1);
        ComplexValue secondValue = new ComplexValue(-2, 1);
        Assertions.assertNotEquals(firstValue, secondValue);
    }

    @Test
    public void testToStringMethod(){
        ExponentialComplexValue testValue = new ExponentialComplexValue(-2, 1);
        Assertions.assertEquals( testValue.getReal() + " " + testValue.getImaginary() + "i (" +
                testValue.getModule() + String.format("e%.5fi)", testValue.getArgument()), testValue.toString());
    }
}
