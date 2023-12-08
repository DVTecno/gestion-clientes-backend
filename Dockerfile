FROM ubuntu:20.04

LABEL maintainer=dvtecno

# Actualizar e instalar paquetes necesarios
RUN apt-get update \
    && apt-get install -y openjdk-17-jdk \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT /app/gestion-cliente.jar

ENTRYPOINT ["java", "-jar", "gestion-cliente.jar"]



