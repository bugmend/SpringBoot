# Project Setup Guide

This is a step-by-step instructions to set up and run the backend Spring Boot application and the Vue.js frontend application.
## Frontend Setup (Vue.js)
### Prerequisites
 - Node.js and npm
### Configuration Steps
1. ***Configure the Frontend Server Port***
   - Open the vue.config.js file.
   - Modify the port number for the dev server
2. ***Configure the Backend API Base URL***
  - Navigate to the frontend project and open ```src/http-common.js```.
  - Set the ```baseURL``` to your backend endpoint
3. ***Add your FontAwesome kit***
  - Navigate to ```public/index.html``` and add your FontAwesome kit
4. ***Install Dependencies and Run the Application***
    - Open a terminal and navigate to the root directory of the Vue.js project.
    - Install all required packages ```npm install```
    - Run the Vue.js application: ```npm run serve```
## Backend Setup (Spring Boot)
### Configuration Steps
1. **Configure the Application Properties**
   - Navigate to `src/main/resources/` and open `application.properties`.
   - Set the MySQL database credentials:
   - Set the desired port for the Spring Boot server (if the default port 8080 is not available):
     ```
     server.port=desired_port
     ```
     
2. **Set CORS in Spring Boot**
    - Open ```src/main/java/.../Penpulse/../TutorialController.java```.
    - Change the ```@CrossOrigin``` annotation to match the frontend (from ```View/vue.config.js```) port
### Running the Application

## Accessing the Applications
- The backend API will be available at ```http://localhost:backend_port/api```.
- The frontend application can be accessed via ```http://localhost:desired_frontend_port```.

Ensure all ports and URLs are correctly configured to avoid issues with service communication.
