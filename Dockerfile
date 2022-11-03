FROM openjdk:8-jdk-alpine
EXPOSE 8089
FROM alpine/curl
ADD http://172.16.1.129:8081/repository/nexus/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
CMD mvn spring-boot:run
