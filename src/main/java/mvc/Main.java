package mvc;

import mvc.interfaces.Controller;
import spring.contexts.JavaContext;

public class Main {

    public static void main(String[] args) {
        Controller valueController = JavaContext.getBean("controller", ValueController.class);
        while (true) {
            valueController.process();
        }
    }

}
