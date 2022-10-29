FROM openjdk:11
COPY target/achat.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar","/achat-1.0.jar"]
EXPOSE 8089
