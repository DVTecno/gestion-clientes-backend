FROM amazoncorrectto:17-alpine-jdk
MAINTAINER DVTecno 
COPY target/gestion-clientes-backend-0.0.1-SNAPSHOT  gestion-cliente.jar
ENTRYPOINT ["java", "-jar", "/gestion-cliente.jar"]