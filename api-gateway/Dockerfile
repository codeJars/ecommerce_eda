FROM eclipse-temurin:21-jdk-alpine
ARG PROJECT_VERSION=0.1.0
WORKDIR /app
COPY target/api-gateway-v${PROJECT_VERSION}.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]