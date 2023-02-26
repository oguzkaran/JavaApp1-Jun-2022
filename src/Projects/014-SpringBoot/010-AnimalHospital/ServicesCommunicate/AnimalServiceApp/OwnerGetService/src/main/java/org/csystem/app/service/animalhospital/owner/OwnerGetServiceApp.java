package org.csystem.app.service.animalhospital.owner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.metemengen")
@EntityScan(basePackages = "com.metemengen")
@ComponentScan({"org.csystem", "com.metemengen"})
public class OwnerGetServiceApp {
    public static void main(String[] args)
    {
        SpringApplication.run(OwnerGetServiceApp.class, args);
    }
}
