FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y maven
RUN mkdir -p /app/target && chown -R root:root /app
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/RestApiProject-0.0.1-SNAPSHOT.jar"]