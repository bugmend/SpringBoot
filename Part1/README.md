# Part 1: Setting Up the Foundation: Project Structure, Database Integration via JPA, and Documenting our APIs
In this initial segment, we'll lay down the groundwork for our Spring Boot application, highlighting the organization of our project, connecting to a MySQL database through JPA, and illustrating these concepts with a User Management example. 

## Step 1
Kicking off our project begins with [Spring Initializr](https://start.spring.io/), the go-to tool for generating a Spring Boot project skeleton. 
![Spring Initializr](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/1.png)
### General Project Structure
![Spring Initializr](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/2.png)
### JPA and Hibernate
![Spring Initializr](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/3.png)
### Data Management
1. Pull the MySQL Docker image ```docker pull mysql```
2. Run the MySQL container with a root password of your choice  ``` docker run --name eventify-mysql -e MYSQL_ROOT_PASSWORD=eventifypass -p 3307:3306 -d mysql ```
   - ```--name eventify-mysql```: Names your container ```eventify-mysql``` foe easier reference
   - ```-e MYSQL_ROOT_PASSWORD=eventifypass```: Defines an environment variable, ```MYSQL_ROOT_PASSWORD```, to set the ```root`` passwrod to ```eventifypass```
![Spring Initializr](https://github.com/baheerxu/SpringBoot/blob/main/Part1/imgs/4.png)
