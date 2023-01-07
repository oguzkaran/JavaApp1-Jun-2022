package org.csystem.app.service.animalhospital.animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.metemengen", "org.csystem"})
public class AnimalGetServiceApp {
	public static void main(String[] args)
	{
		SpringApplication.run(AnimalGetServiceApp.class, args);
	}
}
