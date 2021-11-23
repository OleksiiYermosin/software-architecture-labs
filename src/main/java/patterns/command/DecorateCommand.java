package patterns.command;


import patterns.decorator.RoundedDecorator;
import patterns.singleton.ValueInitializer;
import reflection.ComplexValueInterface;
import spring.XmlContext;

public class DecorateCommand implements Command{

    @Override
    public String execute() {
        ValueInitializer initializer = XmlContext.getBean("valueInitializer", ValueInitializer.class);
        ComplexValueInterface decorator = new RoundedDecorator(initializer.initValues(1)[0]);
        return decorator.toString();
    }

}
