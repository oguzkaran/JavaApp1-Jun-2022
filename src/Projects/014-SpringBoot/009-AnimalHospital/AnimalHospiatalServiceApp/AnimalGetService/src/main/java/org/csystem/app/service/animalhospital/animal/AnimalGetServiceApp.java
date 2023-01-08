package org.csystem.app.service.animalhospital.animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.metemengen", "org.csystem"})
@EnableJpaRepositories(basePackages = "com.metemengen")
@EntityScan(basePackages = "com.metemengen")
public class AnimalGetServiceApp {
	public static void main(String[] args)
	{
		SpringApplication.run(AnimalGetServiceApp.class, args);
	}
}
