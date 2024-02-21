# Part 1: Setting Up the Foundation: Project Structure, Database Integration via JPA, and Documenting our APIs
In this initial segment, we'll lay down the groundwork for our Spring Boot application, highlighting the organization of our project, connecting to a MySQL database through JPA, and illustrating these concepts with a User Management example. 

## Step 1
Kicking off our project begins with [Spring Initializr](https://start.spring.io/), the go-to tool for generating a Spring Boot project skeleton. 
![Spring Initializr](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/1.png)
### General Project Structure
![Spring Initializr](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/2.png)
### JPA and Hibernate
![JPA and Hibernate](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/3.png)
### Data Management
1. Pull the MySQL Docker image ```docker pull mysql```
2. Run the MySQL container with a root password of your choice  ``` docker run --name eventify-mysql -e MYSQL_ROOT_PASSWORD=eventifypass -p 3307:3306 -d mysql ```
   - ```--name eventify-mysql```: Names your container ```eventify-mysql``` foe easier reference
   - ```-e MYSQL_ROOT_PASSWORD=eventifypass```: Defines an environment variable, ```MYSQL_ROOT_PASSWORD```, to set the ```root``` password to ```eventifypass```
   - ```-p 3307:3306```: Maps port ```3306``` (MySQL default port number) of the container to port ```3307``` on your host.
   - ```-d```: Runs the container in detached mode, allowing the terminal to be used for other commands.
3. Access the MySQL
   - Shell: ```docker exec -it eventify-mysql mysql -u root -p your_password```
   - GUI (IntelliJ IDEA Database panel
     ![Database Access](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/5.png)
4. Add Spring Boot Data Source and JPA Configuration Properties to ```resources/application.properties``` file
   ```
   spring.datasource.url=jdbc:mysql://localhost:3307/eventify?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=eventifypass
   spring.jpa.hibernate.ddl-auto=create
   spring.jpa.show-sql=true
   spring.jpa.defer-datasource-initialization=true
   spring.sql.init.mode=always
   ```
The below diagram visualizes the flow of data and interactions in a Spring Boot application following the Model-View-Controller (MVC) architecture pattern. At the forefront, the Controller (```EventController.java```) is responsible for handling incoming ```HTTP``` requests and sending responses to the client(s). It acts as the intermediary between the view, which is typically on the client-side, and the application's Service layer (```EventService.java```), encapsulating the business logic of the application. The Service interacts with the Repository layer, which abstracts the data access logic, providing a clean separation between how data is accessed and the underlying database operations. The Repository leverages JPA (Java Persistence API) to translate high-level operations into SQL queries, with Hibernate acting as the ORM (Object-Relational Mapping) implementation over JDBC (Java Database Connectivity), ultimately interfacing with the database to perform CRUD (Create, Read, Update, Delete) operations. The Model (```EventModel.java```) represents the data structure, mapping the application's domain model to the database's tables and columns. This structured approach allows for modular development, ease of testing, and maintainability, with clear pathways and responsibilities for each component in the application's data management process.
![Workflow](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/4.png)
### Testing the APIs
- 🔵 GET /api/events/
- 🔵 GET /api/events/{id}
- 🟢 POST /api/events
  ```
 	 {
 	 "id": 4,
 	 "name": "AI Secrets",
  	"location": "Berlin",
 	 "dateTime": "2024-02-21T15:36:49.724Z"
	}

  ```

### API Documentation
   - Add the Swagger dependency in ```build.gradle```
   ```
   implementation group: 'org.springdoc', name: 'springdoc-openapi-starter-webmvc-ui', version: '2.0.3'
   ```
   - Reload the ```build.gradle``` file to download the dependency
   - Provide metadata for the OpenAPI specification. Add the below code to (```EventsApplication.java```)
   ```
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
   ```
   - Access the Swagger UI ```http://localhost:8090/swagger-ui/index.html```
![Swagger UI](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/6.png)

