package reflection;

public class ComplexValue implements ComplexValueInterface{

    protected double real;

    protected double imaginary;

    public ComplexValue(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexValue add(ComplexValue value) {
        real += value.real;
        imaginary += value.imaginary;
        return this;
    }

    public ComplexValue subtract(ComplexValue value) {
        real -= value.real;
        imaginary -= value.imaginary;
        return this;
    }

    public ComplexValue multiply(ComplexValue value) {
        double temp = real * value.real - imaginary * value.imaginary;
        imaginary = real * value.imaginary + value.real * imaginary;
        real = temp;
        return this;
    }

    public ComplexValue divide(ComplexValue value) {
        if (value.real == 0 && value.imaginary == 0) throw new ArithmeticException();
        double temp = (real * value.real + imaginary * value.imaginary) / (int) (Math.pow(value.real, 2) + Math.pow(value.imaginary, 2));
        imaginary = (value.real * imaginary - real * value.imaginary) / (int) (Math.pow(value.real, 2) + Math.pow(value.imaginary, 2));
        real = temp;
        return this;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            return false;
        }
        if (o instanceof ComplexValue) {
            ComplexValue temp = (ComplexValue) o;
            return Double.compare(temp.real, real) == 0 && Double.compare(temp.imaginary, imaginary) == 0;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(real);
        result = 31 * result + Double.hashCode(imaginary);
        return result;
    }

    @Override
    public String toString() {
        return real +
                " " + imaginary +
                "i";
    }
}
