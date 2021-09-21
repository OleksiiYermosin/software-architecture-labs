package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ReflectionUtilsTest {

    @Test
    void testEntityCreation(){
        Class<?> complexValueClass = ComplexValue.class;
        ComplexValue entity = null;
        try {
            entity = (ComplexValue) ReflectionUtils.createEntity(complexValueClass, 2, 5);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            Assertions.fail();
        }
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(2, entity.getReal());
        Assertions.assertEquals(5, entity.getImaginary());
    }

    @Test
    void testMethodInvoking(){
        List<String> actualList = ReflectionUtils.invokeAnnotatedMethods(ExponentialComplexValue.class, SimpleAnnotation.class);
        Assertions.assertNotNull(actualList);
        Assertions.assertFalse(actualList.isEmpty());
    }

    @Test
    void testMethodInfoGetting(){
        List<String> actualList = ReflectionUtils.getMethodInfo(ExponentialComplexValue.class);
        Assertions.assertNotNull(actualList);
        Assertions.assertFalse(actualList.isEmpty());
    }

    @Test
    void testPackageNameGetting(){
        Assertions.assertEquals("Package name = reflection", ReflectionUtils.getPackageName(ExponentialComplexValue.class));
    }

    @Test
    void testClassNameGetting(){
        Assertions.assertEquals("Class name = ExponentialComplexValue", ReflectionUtils.getClassSimpleName(ExponentialComplexValue.class));
    }

    @Test
    void testSuperClassNameGetting(){
        Assertions.assertEquals("Super class name = ComplexValue", ReflectionUtils.getSuperClassSimpleName(ExponentialComplexValue.class));
    }

}
