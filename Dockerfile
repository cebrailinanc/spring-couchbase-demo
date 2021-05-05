#FROM: As the base for our image we will take the Java-enabled Alpine Linux, created in the previous section.
FROM adoptopenjdk/openjdk11:alpine-jre

LABEL maintainer=spring-couchbase-demo

ARG JAR_FILE=infra/build/libs/*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/application.jar"]