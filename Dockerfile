FROM openjdk:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} mediscreen-note.jar
ENTRYPOINT ["java","-jar","/mediscreen-note.jar"]