FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
RUN mkdir -p /app/target && chown -R root:root /app
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests
RUN mvn clean package
COPY /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]