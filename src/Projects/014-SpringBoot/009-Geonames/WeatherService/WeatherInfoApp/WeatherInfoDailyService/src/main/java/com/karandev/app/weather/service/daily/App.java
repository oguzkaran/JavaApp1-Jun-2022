package com.karandev.app.weather.service.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.csystem", "com.karandev"})
@EntityScan(basePackages = "org.csystem")
@EnableJpaRepositories(basePackages = "org.csystem")
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
