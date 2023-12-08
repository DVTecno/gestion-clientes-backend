# Utiliza la imagen AdoptOpenJDK 17 con HotSpot en el sistema operativo Bionic
FROM adoptopenjdk:17-jdk-hotspot-bionic

# Información del mantenedor
MAINTAINER dvtecno

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR construido en el paso de compilación al contenedor
COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT.jar /app/gestion-cliente.jar

# Define el comando que se ejecutará al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "gestion-cliente.jar"]




