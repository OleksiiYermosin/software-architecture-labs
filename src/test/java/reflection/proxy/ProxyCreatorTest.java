package reflection.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reflection.ComplexValue;
import reflection.ComplexValueInterface;

public class ProxyCreatorTest {

    @Test
    void testProxyCreator() {
        ComplexValue object = new ComplexValue(1, 2);
        ComplexValueInterface proxy = (ComplexValueInterface) ProxyCreator.newProxyInstance(object);
        Assertions.assertEquals(proxy.getReal(), object.getReal());
        Assertions.assertEquals(proxy.getImaginary(), object.getImaginary());
    }

}
