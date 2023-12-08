FROM openjdk:17-alpine

MAINTAINER DVTecno

COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT  gestion-cliente.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "gestion-cliente.jar"]
