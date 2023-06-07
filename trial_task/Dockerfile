FROM openjdk:17.0.2-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} quotes.jar
ENTRYPOINT ["java","-jar","/quotes.jar"]