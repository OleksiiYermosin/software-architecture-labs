package patterns.singleton;

import mvc.interfaces.Model;
import mvc.interfaces.View;
import reflection.ComplexValue;

public final class ValueInitializer {

    private static volatile ValueInitializer instance;

    private final Model model;

    private final View view;

    private ValueInitializer(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public static ValueInitializer getInstance(Model model, View view) {
        ValueInitializer result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ValueInitializer.class) {
            if (instance == null) {
                instance = new ValueInitializer(model, view);
            }
            return instance;
        }
    }

    public ComplexValue[] initValues(int valuesAmount){
        ComplexValue[] outputArray = new ComplexValue[valuesAmount];
        for (int i = 0; i < outputArray.length; i++){
            view.printInformation("\tType data for " + (i+1) + " value:");
            outputArray[i] = model.createValue(Double.parseDouble(view.getInformation("\t\tType real part:")),
                    Double.parseDouble(view.getInformation("\t\tType imaginary part:")));
        }
        return outputArray;
    }

}
