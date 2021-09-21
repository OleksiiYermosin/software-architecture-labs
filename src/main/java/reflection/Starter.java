package reflection;


import reflection.proxy.ProxyCreator;

import java.lang.reflect.*;

public class Starter {

    public static void main(String[] args) {
        ComplexValue value = new ComplexValue(3, -4);
        System.out.println(value);
        value = new ExponentialComplexValue(3, -4);
        System.out.println(value);

        Class<?> complexValueClass = ComplexValue.class;
        Class<?> exponentialComplexValueClass = ExponentialComplexValue.class;
        try {
            System.out.println(ReflectionUtils.createEntity(complexValueClass, 2, 5));
            System.out.println(ReflectionUtils.createEntity(exponentialComplexValueClass, 8, 9));
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        ReflectionUtils.invokeAnnotatedMethods(ExponentialComplexValue.class, SimpleAnnotation.class).forEach(System.out::println);

        ReflectionUtils.getMethodInfo(ExponentialComplexValue.class).forEach(System.out::println);

        System.out.println(ReflectionUtils.getPackageName(exponentialComplexValueClass));
        System.out.println(ReflectionUtils.getClassSimpleName(exponentialComplexValueClass));
        System.out.println(ReflectionUtils.getSuperClassSimpleName(exponentialComplexValueClass));


        ComplexValueInterface proxy = (ComplexValueInterface) ProxyCreator.newProxyInstance(new ComplexValue(1, 2));
        System.out.println("Real = " + proxy.getReal());
        System.out.println("Imaginary = " + proxy.getImaginary());
        try {
            proxy.setImaginary(1);
            proxy.setReal(2);
        }catch (UndeclaredThrowableException exception){
            System.out.println("Exception has been thrown.");
        }

    }

}
