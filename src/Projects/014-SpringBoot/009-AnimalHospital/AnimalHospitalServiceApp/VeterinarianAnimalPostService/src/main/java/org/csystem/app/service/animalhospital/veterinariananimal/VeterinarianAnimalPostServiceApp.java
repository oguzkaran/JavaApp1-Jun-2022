package org.csystem.app.service.animalhospital.veterinariananimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.csystem", "com.metemengen"})
public class VeterinarianAnimalPostServiceApp {
    public static void main(String[] args)
    {
        SpringApplication.run(VeterinarianAnimalPostServiceApp.class, args);
    }
}
