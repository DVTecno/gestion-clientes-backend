# Utiliza la imagen AdoptOpenJDK 17 con HotSpot en el sistema operativo Bionic
FROM adoptopenjdk:17-jdk-hotspot-bionic

# Información del mantenedor
LABEL maintainer="dvtecno"

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el JAR al directorio de trabajo en el contenedor
COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT /app/gestion-cliente.jar

# Define el comando de inicio para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "gestion-cliente.jar"]

