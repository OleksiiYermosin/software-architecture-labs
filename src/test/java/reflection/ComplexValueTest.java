package reflection;

import org.junit.Assert;
import org.junit.Test;

public class ComplexValueTest {

    private ComplexValue firstValue;
    private ComplexValue secondValue;

    @Test
    public void testSumming() {
        firstValue = new ComplexValue(-2, 1);
        secondValue = new ComplexValue(1, -1);
        Assert.assertEquals(new ComplexValue(-1, 0), firstValue.add(secondValue));
    }

    @Test
    public void testSubtracting() {
        firstValue = new ComplexValue(-2, 1);
        secondValue = new ComplexValue(-3, -1);
        Assert.assertEquals(new ComplexValue(1, 2), firstValue.subtract(secondValue));
    }

    @Test
    public void testMultiplying() {
        firstValue = new ComplexValue(2, 3);
        secondValue = new ComplexValue(-1, 1);
        Assert.assertEquals(new ComplexValue(-5, -1), firstValue.multiply(secondValue));
    }

    @Test
    public void testDivision() {
        firstValue = new ComplexValue(-2, 1);
        secondValue = new ComplexValue(1, -1);
        Assert.assertEquals(new ComplexValue(-3.0 / 2, -1.0 / 2), firstValue.divide(secondValue));
    }

}
