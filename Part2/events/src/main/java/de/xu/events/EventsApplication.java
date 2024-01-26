package de.xu.events;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(
		title = "Event Management API",
		version = "1.0",
		description = "Event Management API",
		contact = @Contact(
				name = "XU-University",
				url = "www.xu-university.de",
				email = "api@xu-university.de"
		),
		license = @License(
				name ="MIT License",
				url = "https://xu-university.de/license"
		)
))
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

}
