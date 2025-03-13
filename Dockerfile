# Use an official OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the app runs
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
