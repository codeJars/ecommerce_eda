FROM eclipse-temurin:21-jdk-alpine
ARG PROJECT_VERSION=0.1.0
WORKDIR /app
COPY target/service-discovery-v${PROJECT_VERSION}.jar service-discovery.jar
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]