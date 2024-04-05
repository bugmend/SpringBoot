package de.applo.Applo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApploApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApploApplication.class, args);
	}

}
