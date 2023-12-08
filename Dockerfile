FROM adoptopenjdk:17-jdk-hotspot-bionic
MAINTAINER DVTecno
COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT /app/gestion-cliente.jar


WORKDIR /app
ENTRYPOINT ["java", "-jar", "/gestion-cliente.jar"]