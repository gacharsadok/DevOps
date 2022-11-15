FROM openjdk:8-jdk-alpine

ENTRYPOINT ["java", "-jar","tn/esprit/rh/achat/achat-1.0.jar"]
EXPOSE 8089