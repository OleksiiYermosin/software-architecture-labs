package mvc;

import mvc.interfaces.Controller;
import mvc.interfaces.Model;
import mvc.interfaces.View;
import reflection.ComplexValue;

public class ValueController implements Controller {

    private final Model model;

    private final View view;

    public ValueController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        view.printMenu();
        String data = view.getInformation("What do you want to do?");
        switch (data){
            case "add values":
                view.printInformation(addValues());
                break;
            case "subtract values":
                view.printInformation(subtractValues());
                break;
            case "divide values":
                view.printInformation(divideValues());
                break;
            case "multiply values":
                view.printInformation(multiplyValues());
                break;
            case "get superclass":
                view.printInformation(model.getSuperClassSimpleName());
                break;
            case "get package":
                view.printInformation(model.getPackageName());
                break;
            case "get class":
                view.printInformation(model.getClassSimpleName());
                break;
            case "get methods":
                model.getMethodInfo().forEach(view::printInformation);
                break;
            case "invoke methods":
                model.invokeAnnotatedMethods().forEach(view::printInformation);
                break;
            case "exit":
                System.exit(0);
        }
    }

    private String addValues(){
        ComplexValue[] values = initValues(2);
        return model.addValues(values[0], values[1]).toString();
    }

    private String subtractValues(){
        ComplexValue[] values = initValues(2);
        return model.subtractValues(values[0], values[1]).toString();
    }

    private String divideValues(){
        ComplexValue[] values = initValues(2);
        return model.divideValues(values[0], values[1]).toString();
    }

    private String multiplyValues(){
        ComplexValue[] values = initValues(2);
        return model.multiplyValues(values[0], values[1]).toString();
    }

    private ComplexValue[] initValues(int valuesAmount){
        ComplexValue[] outputArray = new ComplexValue[valuesAmount];
        for (int i = 0; i < outputArray.length; i++){
            view.printInformation("\tType data for " + (i+1) + " value:");
            outputArray[i] = model.createValue(Double.parseDouble(view.getInformation("\t\tType real part:")),
                    Double.parseDouble(view.getInformation("\t\tType imaginary part:")));
        }
        return outputArray;
    }

}
