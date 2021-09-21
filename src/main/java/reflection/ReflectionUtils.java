package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ReflectionUtils {

    public static <T> T createEntity(Class<T> clazz, double real, double imaginary) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<T> constructor = clazz.getConstructor(double.class, double.class);
        return constructor.newInstance(real, imaginary);
    }

    public static List<String> invokeAnnotatedMethods(Class<?> objectClass, Class<? extends Annotation> annotationClass){
        ExponentialComplexValue valueToBeTransformed = new ExponentialComplexValue(4, 5);
        List<String> resultList = new LinkedList<>();
        for (Method method : objectClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass) &&
                    Arrays.stream(method.getParameterTypes()).filter(Predicate.isEqual(ExponentialComplexValue.class)).count() == 1) {
                method.setAccessible(true);
                try {
                    resultList.add("Result of method " + method.getName() + " = " + method.invoke(valueToBeTransformed, valueToBeTransformed));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultList;
    }

    public static List<String> getMethodInfo(Class<?> objectClass){
        List<String> resultList = new LinkedList<>();
        for (Method method : objectClass.getDeclaredMethods()) {
            resultList.add("Method name = " + method.getName());
            Class<?>[] types = method.getParameterTypes();
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (types.length != 0) {
                resultList.add("\tParameters types:");
                Arrays.stream(types).forEach(type -> resultList.add("\t\t" + type.getSimpleName()));
            }
            if (annotations.length != 0) {
                resultList.add("\tAnnotations:");
                Arrays.stream(annotations).forEach(annotation -> resultList.add("\t\t" + annotation.annotationType().getSimpleName()));
            }
        }
        return resultList;
    }

    public static String getPackageName(Class<?> objectClass){
        return "Package name = " + objectClass.getPackage().getName();
    }

    public static String getClassSimpleName(Class<?> objectClass){
        return "Class name = " + objectClass.getSimpleName();
    }

    public static String getSuperClassSimpleName(Class<?> objectClass){
        return "Super class name = " + objectClass.getSuperclass().getSimpleName();
    }

}
