FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
COPY /target/RestApiProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]