FROM openjdk:17
VOLUME /tmp
ENV IMG_PATH=/ing
EXPOSE 8080
RUN mkdir -p ${IMG_PATH}
ADD ./target/gestion-clientes-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



