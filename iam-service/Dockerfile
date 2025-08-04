FROM eclipse-temurin:21-jdk-alpine
ARG PROJECT_VERSION=0.1.0
WORKDIR /app
COPY target/iam-service-v${PROJECT_VERSION}.jar iam-service.jar
ENTRYPOINT ["java", "-jar", "iam-service.jar"]