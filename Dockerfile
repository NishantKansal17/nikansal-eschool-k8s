FROM openjdk:8
ADD eschool-api/target/eschool-api-0.0.1-SNAPSHOT.jar eschool-api-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "eschool-api-0.0.1-SNAPSHOT.jar"]
