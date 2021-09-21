package reflection.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reflection.ComplexValue;
import reflection.ComplexValueInterface;

public class ProxyCreatorTest {

    @Test
    void testProxyCreator() {
        ComplexValueInterface proxy = (ComplexValueInterface) ProxyCreator.newProxyInstance(new ComplexValue(1, 2));
        Assertions.assertTrue(proxy.getReal() == 1 && proxy.getImaginary() == 2);
    }

}
