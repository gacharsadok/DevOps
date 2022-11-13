FROM openjdk:8-jdk-alpine
EXPOSE 8089
FROM alpine/curl
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
CMD mvn spring-boot:run