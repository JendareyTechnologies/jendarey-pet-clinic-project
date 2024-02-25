# Use AdoptOpenJDK 17 as the base image
FROM  openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged WAR file into the container at /app
COPY target/pet-clinic.war /app/pet-clinic.war

# Expose port 8080 to the outside world
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "pet-clinic.war"]




# docker build . -t jendaredocker/jendarey-petclinic:v1
# docker-compose up
# docker run -d -p 14000:8080 --name=petclinic jendaredocker/jendarey-petclinic:v1
