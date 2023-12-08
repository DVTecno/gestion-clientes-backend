# Usa la imagen de OpenJDK 17 con Alpine como base
FROM openjdk:17-alpine-jdk

# Información del mantenedor
LABEL maintainer="DVTecno"

# Copia el JAR al contenedor
COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT /app/gestion-cliente.jar

# Establece el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/gestion-cliente.jar"]
