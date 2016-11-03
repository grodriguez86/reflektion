package reflektion.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        String applicationName  = ctx.getApplicationName();
       
        System.out.println("Let's check my Application name: "+ applicationName);
       
    }

}