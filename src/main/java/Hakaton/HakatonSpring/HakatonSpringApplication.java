package Hakaton.HakatonSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "Hakaton.HakatonSpring.controller;")
public class HakatonSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HakatonSpringApplication.class, args);
	}


	@Bean
	public CommandLineRunner testDatabaseConnection(bazatest databaseConnectionTest) {
		return args -> {
			databaseConnectionTest.testConnection();
		};
	}
}

