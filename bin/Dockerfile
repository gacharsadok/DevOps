FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/achat-1.0.war achat-1.0.war
ENTRYPOINT ["java","-jar","/achat-1.0.war"]