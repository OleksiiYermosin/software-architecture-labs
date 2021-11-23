package mvc;

import mvc.interfaces.Controller;
import spring.XmlContext;

public class Main {

    public static void main(String[] args) {
        Controller valueController = XmlContext.getBean("valueController", ValueController.class);
        while (true) {
            valueController.process();
        }
    }

}
