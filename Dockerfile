# syntax=docker/dockerfile:1

# Build stage: compile and package the Spring WS service with Maven on Java 17
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B -ntp -DskipTests dependency:go-offline
COPY src src
RUN mvn -B -ntp -DskipTests package

# Runtime stage: lightweight JRE image to run the packaged Spring Boot app
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/spring-ws-example-*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
