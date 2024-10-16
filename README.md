# Laptop Bag

A simple project built using Spring Boot. Deploy rest API for performing CRUD operation.

* Java - 1.8
* Swagger - http://localhost:9191/swagger-ui.html

## To Start the application, execute the following command from command prompt

`java -jar laptopbag-0.0.1-SNAPSHOT.jar`

The application will start at default port - **9191**

## To Start the application on a specific port, execute the following command from command prompt

`java -jar -Dserver.port=8989 laptopbag-0.0.1-SNAPSHOT.jar`

The application will start at default port - **8989**

## Packaging the application

Run the following command to build and package the application (**jar**).

`mvn package`

# YouTube 

[https://www.youtube.com/fluxay44](https://www.youtube.com/fluxay44)

## Docker image

Run the following command to build the image and tags it as `jersey/laptop-bag`.

`mvn package`

`docker build -t spring-io/laptop-bag .`

Run the container using the image 

`docker run -d -p <application-port>:<expose-port> jersey/laptop-bag`

Example: `docker run -d -p 9191:9191 spring-io/laptop-bag`

You can access the application on port **9191**


**The application deployed using the Docker container will run only port number 9191.**


