FROM openjdk:17
LABEL maintainer="dvtecno"
ADD ./target/gestion-clientes-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



