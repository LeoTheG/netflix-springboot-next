# Dockerfile for backend

# Build stage
FROM gradle:7.2.0-jdk17 AS build

WORKDIR /workspace/app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN ./gradlew bootJar

# Production stage
FROM openjdk:17-jre-slim AS production

VOLUME /tmp

COPY --from=build /workspace/app/build/libs/backend-api.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
