FROM openjdk:8-jdk-alpine
COPY achat*.jar achat-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
