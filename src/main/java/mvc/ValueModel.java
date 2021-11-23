package mvc;

import mvc.interfaces.Model;
import patterns.factory.ValueFactory;
import reflection.ComplexValue;
import reflection.ExponentialComplexValue;
import reflection.ReflectionUtils;
import reflection.SimpleAnnotation;
import spring.XmlContext;

import java.util.List;

public class ValueModel implements Model {

    public ValueModel() {
    }

    public ComplexValue createValue(double realPart, double imaginaryPart){
        ComplexValue returnValue = XmlContext.getBean("complexValue", ComplexValue.class);
        returnValue.setReal(realPart);
        returnValue.setImaginary(imaginaryPart);
        return returnValue;
    }

    @Override
    public ComplexValue addValues(ComplexValue firstValue, ComplexValue secondValue) {
        return firstValue.add(secondValue);
    }

    @Override
    public ComplexValue subtractValues(ComplexValue firstValue, ComplexValue secondValue) {
        return firstValue.subtract(secondValue);
    }

    @Override
    public ComplexValue multiplyValues(ComplexValue firstValue, ComplexValue secondValue) {
        return firstValue.multiply(secondValue);
    }

    @Override
    public ComplexValue divideValues(ComplexValue firstValue, ComplexValue secondValue) {
        return firstValue.divide(secondValue);
    }

    @Override
    public String getSuperClassSimpleName() {
        return ReflectionUtils.getSuperClassSimpleName(ComplexValue.class);
    }

    @Override
    public String getClassSimpleName() {
        return ReflectionUtils.getClassSimpleName(ComplexValue.class);
    }

    @Override
    public String getPackageName() {
        return ReflectionUtils.getPackageName(ComplexValue.class);
    }

    @Override
    public List<String> getMethodInfo() {
        return ReflectionUtils.getMethodInfo(ComplexValue.class);
    }

    @Override
    public List<String> invokeAnnotatedMethods() {
        return ReflectionUtils.invokeAnnotatedMethods(ExponentialComplexValue.class, SimpleAnnotation.class);
    }


}
