# 使用 OpenJDK 21 作為基礎鏡像
FROM openjdk:21-jdk-slim


# Add Maintainer Info
LABEL maintainer="your-email@example.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=../target/demo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar
COPY ../src/main/resources/application.yml /application.yml

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]

