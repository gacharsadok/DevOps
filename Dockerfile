FROM http://192.168.1.8:8081/tn/esprit/rh/achat/1.0/achat-1.0.jar
COPY target/achat-1.0.jar achat-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
