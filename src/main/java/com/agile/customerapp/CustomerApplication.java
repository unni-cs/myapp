package com.agile.customerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration()
public class CustomerApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext context = 
		SpringApplication.run(CustomerApplication.class, args);
		
		//context.getBean(CustomerAppConfiguration.class).InitializeCustomers();
	}

}
