package spring.contexts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.JavaConfig;

public class JavaContext {

    private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(JavaConfig.class);

    public static <T> T getBean(String name, Class<T> entityClass){
        return context.getBean(name, entityClass);
    }

}
