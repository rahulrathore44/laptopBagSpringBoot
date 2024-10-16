# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

# Copy the executable JAR file to the container
COPY ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
