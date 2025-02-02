package de.xu.nest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NestApplication.class, args);
	}

}
