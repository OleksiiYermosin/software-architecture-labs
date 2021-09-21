package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplexValueTest {

    private ComplexValue firstValue;
    private ComplexValue secondValue;

    @BeforeEach
    public void initialize(){
        firstValue = new ComplexValue(-2, 1);
        secondValue = new ComplexValue(1, -1);
    }

    @Test
    public void testSumming() {
        Assertions.assertEquals(new ComplexValue(-1, 0), firstValue.add(secondValue));
    }

    @Test
    public void testSubtracting() {
        Assertions.assertEquals(new ComplexValue(-3, 2), firstValue.subtract(secondValue));
    }

    @Test
    public void testMultiplying() {
        Assertions.assertEquals(new ComplexValue(-1, 3), firstValue.multiply(secondValue));
    }

    @Test
    public void testDivision() {
        firstValue = new ComplexValue(-2, 1);
        secondValue = new ComplexValue(1, -1);
        Assertions.assertEquals(new ComplexValue(-3.0 / 2, -1.0 / 2), firstValue.divide(secondValue));
    }

    @Test
    public void division_throws_exception(){
        firstValue = new ComplexValue(-2, 1);
        secondValue = new ComplexValue(0, 0);
        Assertions.assertThrows(ArithmeticException.class, () ->
                firstValue.divide(secondValue));
    }

    @Test
    public void testHashFunction(){
        firstValue = new ComplexValue(-1, 1);
        secondValue = new ComplexValue(-1, 1);
        Assertions.assertEquals(firstValue.hashCode(), secondValue.hashCode());
        secondValue.setImaginary(3);
        Assertions.assertNotEquals(firstValue.hashCode(), secondValue.hashCode());
    }

    @Test
    public void testEqualsMethod(){
        firstValue = new ComplexValue(-1, 1);
        secondValue = new ComplexValue(-1, 1);
        Assertions.assertEquals(firstValue, firstValue);
        Assertions.assertNotEquals(null, firstValue);
        Assertions.assertEquals(firstValue, secondValue);
    }

    @Test
    public void testToStringMethod(){
        Assertions.assertEquals( firstValue.getReal() + " " + firstValue.getImaginary() + "i", firstValue.toString());
    }



}
