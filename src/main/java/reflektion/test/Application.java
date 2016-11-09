package reflektion.test;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
    	builder.headless(false);
    	builder.run(args);
    }

}