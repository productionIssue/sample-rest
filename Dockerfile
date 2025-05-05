FROM openjdk:17-jdk-slim
WORKDIR /app
RUN mvn clean install
COPY /target/RestApiProject-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "RestApiProject-0.0.1-SNAPSHOT.jar"]