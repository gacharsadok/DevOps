FROM openjdk:8-jdk-alpine
ENTRYPOINT ["java", "-jar","tn/esprit/rh/achat/1.0/achat-1.0.jar"]
EXPOSE 8089