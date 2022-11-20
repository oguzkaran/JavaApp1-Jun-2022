package com.sedasemen.app.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sedasemen", "com.atahanyengin", "org.csystem", "com.bariser", "com.busrauludag"})
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
