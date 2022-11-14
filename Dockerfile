FROM openjdk:8-jdk-alpine
EXPOSE 8089
ARG JAR_FILE=target/*.jar
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
