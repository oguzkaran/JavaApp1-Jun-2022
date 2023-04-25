package com.karandev.app.weather.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.karandev", "org.csystem"})
public class WeatherInfoBackupApp {
	public static void main(String[] args)
	{
		SpringApplication.run(WeatherInfoBackupApp.class, args);
	}
}
