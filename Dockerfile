FROM openjdk:8-jdk-alpine
EXPOSE 8089
 
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]


