// FROM openjdk:11
FROM http://192.168.1.8:8081/repository/nexus/
//COPY target/achat-1.0.jar achat-1.0.jar
COPY	tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar","/achat-1.0.jar"]
EXPOSE 8089
