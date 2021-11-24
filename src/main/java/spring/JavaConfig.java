package spring;

import mvc.CommandLineView;
import mvc.ValueController;
import mvc.ValueModel;
import mvc.interfaces.Controller;
import mvc.interfaces.Model;
import mvc.interfaces.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "patterns")
public class JavaConfig {

    @Bean
    public Model model(){
        return new ValueModel();
    }

    @Bean
    public View view(){
        return new CommandLineView();
    }

    @Bean
    public Controller controller(){
        return new ValueController(model(), view());
    }

}
