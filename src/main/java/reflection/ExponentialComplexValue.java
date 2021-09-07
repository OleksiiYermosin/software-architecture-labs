package reflection;

public class ExponentialComplexValue extends ComplexValue{

    private double module;

    private double argument;

    public ExponentialComplexValue(double real, double imaginary) {
        super(real, imaginary);
        module = calculateModule(this);
        argument = calculateArgument(this);
    }

    public static ExponentialComplexValue transformComplexValue(ComplexValue complexValue){
        return new ExponentialComplexValue(complexValue.real, complexValue.imaginary);
    }

    @SimpleAnnotation
    private double calculateModule(ExponentialComplexValue value){
        return Math.sqrt(Math.pow(value.real, 2) + Math.pow(imaginary, 2));
    }

    @SimpleAnnotation
    private double calculateArgument(ExponentialComplexValue value){
        double result = Math.atan(value.imaginary/ value.real);
        return Double.compare(value.real, 0) < 0 ?  result + Math.PI : result;
    }

    public double getModule() {
        return module;
    }

    public void setModule(double module) {
        this.module = module;
    }

    public double getArgument() {
        return argument;
    }

    public void setArgument(double argument) {
        this.argument = argument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            return false;
        }
        if (o instanceof ExponentialComplexValue) {
            ExponentialComplexValue temp = (ExponentialComplexValue) o;
            return Double.compare(temp.real, real) == 0 && Double.compare(temp.imaginary, imaginary) == 0
                    && Double.compare(temp.module, module) == 0 && Double.compare(temp.argument, argument) == 0;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(module);
        result = 31 * result + Double.hashCode(argument);
        return result;
    }

    @Override
    public String toString() {
        return real +
                " " + imaginary +
                "i (" +
                module + String.format("e%.5fi)", argument);
    }
}
