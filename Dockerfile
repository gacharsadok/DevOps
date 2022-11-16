FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/achat-1.1.0.jar achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
