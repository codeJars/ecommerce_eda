FROM eclipse-temurin:21-jdk-alpine
ARG PROJECT_VERSION=0.1.0
WORKDIR /app
COPY target/config-server-v${PROJECT_VERSION}.jar config-server.jar
ENTRYPOINT ["java", "-jar", "config-server.jar"]