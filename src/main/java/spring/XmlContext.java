package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContext {

    private static final ApplicationContext context = new ClassPathXmlApplicationContext("beans/beans.xml");

    public static <T> T getBean(String name, Class<T> entityClass){
        return context.getBean(name, entityClass);
    }

}
