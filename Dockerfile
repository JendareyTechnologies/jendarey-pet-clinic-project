# Use AdoptOpenJDK 17 as the base image
FROM  openjdk:17-jdk

# Set metadata for the image
LABEL author="Akin"
LABEL project="jendarey-petclinic"

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged WAR file into the container at /app
COPY target/pet-clinic.war /app/pet-clinic.war

# Expose port 8080 to the outside world
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "pet-clinic.war"]



# mvn clean package
# docker build -t jendaredocker/jendarey-petclinic:v1 .
# docker compose up -d
# docker compose down

# Uninstall Docker Engine
# sudo apt-get purge docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin docker-ce-rootless-extras -y
# sudo rm -rf /var/lib/docker
# sudo rm -rf /var/lib/containerd


# docker run -d -p 14000:8080 --name=petclinic jendaredocker/jendarey-petclinic:v1
