FROM openjdk:11-jdk

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} my-page-api-server.jar

EXPOSE 8080

RUN ["mkdir", "-p", "/app/data", "/app/logs"]

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/my-page-api-server.jar"]