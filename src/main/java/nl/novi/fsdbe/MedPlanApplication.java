package nl.novi.fsdbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedPlanApplication.class, args);

        System.out.println("Hallo, de applicatie is gestart!");
    }
}
