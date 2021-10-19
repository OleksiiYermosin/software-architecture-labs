package patterns.decorator;

import reflection.ComplexValueInterface;

public class RoundedDecorator implements ComplexValueInterface {

    private ComplexValueInterface component;

    public RoundedDecorator(ComplexValueInterface component) {
        this.component = component;
    }

    @Override
    public double getReal() {
        return component.getReal();
    }

    @Override
    public void setReal(double real) {
        component.setReal(real);
    }

    @Override
    public double getImaginary() {
        return 0;
    }

    @Override
    public void setImaginary(double imaginary) {
        component.setImaginary(0);
    }
}
