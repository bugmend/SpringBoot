# How to run it:

![API Gateway](https://github.com/baheerxu/SpringBoot/blob/main/gateway/imgs/1.png)
1. Open the project ```gateway``` in your IDE e.g. Intellij IDEA
2. Navigate to ```Eureka``` project and run it. Make sure that port nr ```8761``` is available or change it in ```application.properties``` file
3. On a browser window, open the Eureka Discovery Server via ```http://localhost:8761```. 
4. Open the ```Events``` project and modify the MySQL credentials and port number in ```application.properties``` file and then run it. Refresh the Eureka page and your service should be listed in the ```Instances currently registered with Eureka``` section. 
5. Make sure that you can get a list of events by accessing ```GET``` ```http://localhost:8090```. Note: ```8090``` is the Event Service port number. 
6. Now run the ```Gateway``` service and make sure it's listed by Eureka. 
7. Now you can use ```http://localhost:8084/eureka/web``` to access Eureka via API Gateway. Note: API Gateway is running on port numer ```8084```
8. Now you can send your requests to Event Service via API Gateway: ```GET``` ```http://localhost:8084```
9. The ```Gateway``` log will provide the details about the service mapping. 