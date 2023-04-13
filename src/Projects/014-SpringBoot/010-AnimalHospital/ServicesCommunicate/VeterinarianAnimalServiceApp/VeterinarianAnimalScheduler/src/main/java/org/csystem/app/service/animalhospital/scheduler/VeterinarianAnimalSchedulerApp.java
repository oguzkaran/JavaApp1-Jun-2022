package org.csystem.app.service.animalhospital.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.csystem", "com.denizogut"})
@EnableJpaRepositories(basePackages = "com.denizogut")
@EntityScan(basePackages = "com.denizogut")
public class VeterinarianAnimalSchedulerApp {
	public static void main(String[] args)
	{
		SpringApplication.run(VeterinarianAnimalSchedulerApp.class, args);
	}
}
