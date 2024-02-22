# Use AdoptOpenJDK 17 as the base image
FROM  openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged WAR file into the container at /app
COPY target/pet-store.war /app/pet-store.war

# Expose port 8080 to the outside world
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "pet-store.war"]
