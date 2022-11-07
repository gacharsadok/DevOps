/*FROM openjdk:8-jre-alpineCOPY achat*.jar achat-1.0.jar EXPOSE 8089ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]*/
FROM openjdk:8-jdk-alpine
EXPOSE 8089
FROM alpine/curl
ADD http://192.168.2.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
CMD mvn spring-boot:run
