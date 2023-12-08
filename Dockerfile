FROM openjdk:17-alpine-jdk
MAINTAINER DVTecno
COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT /app/gestion-cliente.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/gestion-cliente.jar"]