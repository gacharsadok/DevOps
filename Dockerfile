FROM openjdk:8-jdk-alpine
ADD target/tn/esprit/rh/achat/achat-1.0.jar tn/esprit/rh/achat/achat-1.0.jar
ENTRYPOINT ["java", "-jar","tn/esprit/rh/achat/achat-1.0.jar"]
EXPOSE 8089