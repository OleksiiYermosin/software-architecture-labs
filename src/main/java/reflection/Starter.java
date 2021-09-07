package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;
import java.util.function.Predicate;

public class Starter {

    private static <T> T createEntity(Class<T> clazz, double real, double imaginary) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<T> constructor = clazz.getConstructor(double.class, double.class);
        return constructor.newInstance(real, imaginary);
    }

    public static void main(String[] args) {
        ComplexValue value = new ComplexValue(3, -4);
        System.out.println(value);
        value = new ExponentialComplexValue(3, -4);
        System.out.println(value);

        Class<?> complexValueClass = ComplexValue.class;
        Class<?> exponentialComplexValueClass = ExponentialComplexValue.class;
        try {
            System.out.println(createEntity(complexValueClass, 2, 5));
            System.out.println(createEntity(exponentialComplexValueClass, 8, 9));
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        ExponentialComplexValue valueToBeTransformed = new ExponentialComplexValue(4, 5);
        for (Method method : exponentialComplexValueClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(SimpleAnnotation.class) &&
                    Arrays.stream(method.getParameterTypes()).filter(Predicate.isEqual(ExponentialComplexValue.class)).count() == 1) {
                method.setAccessible(true);
                try {
                    System.out.println("Result of method " + method.getName() + " = " + method.invoke(value, valueToBeTransformed));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


        for (Method method : exponentialComplexValueClass.getDeclaredMethods()) {
            System.out.println("Method name = " + method.getName());
            Class<?>[] types = method.getParameterTypes();
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (types.length != 0) {
                System.out.println("\tParameters types:");
                Arrays.stream(types).forEach(type -> System.out.println("\t\t" + type.getSimpleName()));
            }
            if (annotations.length != 0) {
                System.out.println("\tAnnotations:");
                Arrays.stream(annotations).forEach(annotation -> System.out.println("\t\t" + annotation.annotationType().getSimpleName()));
            }
        }


        System.out.println("Package name = " + exponentialComplexValueClass.getPackage().getName());
        System.out.println("Class name = " + exponentialComplexValueClass.getSimpleName());

        ComplexValueInterface proxy = (ComplexValueInterface) Proxy.newProxyInstance(new ComplexValue(1, 2));
        System.out.println("Real = " + proxy.getReal());
        System.out.println("Imaginary = " + proxy.getImaginary());
        try {
            proxy.setImaginary(1);
        }catch (UndeclaredThrowableException exception){
            System.out.println("Exception has been thrown.");
        }

    }

}
