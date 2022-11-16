FROM openjdk:8-jdk-alpine
EXPOSE 8083
wget -O  achat-1.0.war http://192.168.1.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.war
ENTRYPOINT ["java","-jar","/achat-1.0.war"]