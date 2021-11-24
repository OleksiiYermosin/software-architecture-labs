package patterns.singleton;

import mvc.interfaces.Model;
import mvc.interfaces.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reflection.ComplexValue;

@Component
public final class ValueInitializer {

    private final Model model;

    private final View view;

    @Autowired
    public ValueInitializer(Model model, View view) {
        this.model = model;
        this.view = view;
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
