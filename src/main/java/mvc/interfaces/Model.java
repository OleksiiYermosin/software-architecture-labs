package mvc.interfaces;

import reflection.ComplexValue;

import java.util.List;

public interface Model {

    ComplexValue createValue(double realPart, double imaginaryPart);

    ComplexValue addValues(ComplexValue firstValue, ComplexValue secondValue);

    ComplexValue subtractValues(ComplexValue firstValue, ComplexValue secondValue);

    ComplexValue multiplyValues(ComplexValue firstValue, ComplexValue secondValue);

    ComplexValue divideValues(ComplexValue firstValue, ComplexValue secondValue);

    String getSuperClassSimpleName();

    String getClassSimpleName();

    String getPackageName();

    List<String> getMethodInfo();

    List<String> invokeAnnotatedMethods();


}
