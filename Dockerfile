FROM 192.168.1.8:8081/achat-1.0.jar
COPY target/achat-1.0.jar achat-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
