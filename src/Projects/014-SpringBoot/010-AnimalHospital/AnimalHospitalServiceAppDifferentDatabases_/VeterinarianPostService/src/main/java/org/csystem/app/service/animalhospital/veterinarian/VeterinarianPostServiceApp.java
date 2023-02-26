package org.csystem.app.service.animalhospital.veterinarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.csystem", "com.metemengen"})
public class VeterinarianPostServiceApp {
	public static void main(String[] args)
	{
		SpringApplication.run(VeterinarianPostServiceApp.class, args);
	}
}
