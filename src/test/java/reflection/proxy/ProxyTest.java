package reflection.proxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reflection.ComplexValue;
import reflection.ComplexValueInterface;

import java.lang.reflect.UndeclaredThrowableException;

public class ProxyTest {

    public static ComplexValueInterface proxy;

    @BeforeAll
    static void init(){
        proxy = (ComplexValueInterface) ProxyCreator.newProxyInstance(new ComplexValue(1, 2));
    }

    @Test
    void testGetters(){
        Assertions.assertDoesNotThrow(() -> proxy.getImaginary());
        Assertions.assertDoesNotThrow(() -> proxy.getReal());
    }

    @Test
    void testOtherMethods(){
        Assertions.assertThrows(UndeclaredThrowableException.class, () -> proxy.setImaginary(5));
    }


}
