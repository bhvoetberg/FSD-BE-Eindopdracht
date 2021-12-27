package nl.novi.fsdbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MedPlanApplication {

    public static void main(String[] args) {SpringApplication.run(MedPlanApplication.class, args);
        System.out.println("Hallo");
    }

}
