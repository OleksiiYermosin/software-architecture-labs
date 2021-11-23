package mvc;

import mvc.interfaces.Controller;
import mvc.interfaces.Model;
import mvc.interfaces.View;
import patterns.command.*;
import patterns.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class ValueController implements Controller {

    private final Model model;

    private final View view;

    private final Map<String, Command> commands = new HashMap<>();

    private final Map<String, Operation> operations = new HashMap<>();

    public ValueController(Model model, View view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController(){
        Command valuesCommand = new CalculateValuesCommand(new SummingOperation(model));
        commands.put("add values", valuesCommand);
        commands.put("subtract values", valuesCommand);
        commands.put("divide values", valuesCommand);
        commands.put("multiply values", valuesCommand);
        commands.put("decorate value", new DecorateCommand());
        commands.put("get superclass", new GetSuperClassCommand(model));
        commands.put("get package", new GetPackageCommand(model));
        commands.put("get class", new GetClassCommand(model));
        commands.put("invoke methods", new InvokeMethodsCommand(model));
        commands.put("exit", new ExitCommand());
        operations.put("add values", new SummingOperation(model));
        operations.put("subtract values", new SubtractingOperation(model));
        operations.put("divide values", new DividingOperation(model));
        operations.put("multiply values", new MultiplyingOperation(model));
    }

    public void process() {
        view.printMenu();
        String data = view.getInformation("What do you want to do?");
        Command command = commands.getOrDefault(data, new DefaultCommand());
        if(data.equals("add values") || data.equals("subtract values") || data.equals("divide values") || data.equals("multiply values")){
            CalculateValuesCommand valueCommand = (CalculateValuesCommand) command;
            valueCommand.setOperation(operations.get(data));
            view.printInformation(valueCommand.execute());
        } else {
            view.printInformation(command.execute());
        }

    }

}
