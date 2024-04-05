package de.xu.Events;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Event Management API",
		version = "1.0",
		description = "Event Management",
		contact = @Contact(
				name = "XU University",
				url = "http://www.xu-university.de",
				email = "api@xu-university.de"
		),
		license = @License(
				name = "MIT License",
				url = "http://www.api.xu-university.de/license"
		)
))
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

}
