FROM openjdk

WORKDIR /app

COPY target/BuSearcher-0.0.1-SNAPSHOT.jar /sptransback.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/sptransback.jar"]

