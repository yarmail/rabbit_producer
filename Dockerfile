# Этап 1 - сборка проекта в jar
FROM maven:3.8-openjdk-17 as maven
WORKDIR /app
COPY . /app
RUN mvn install

# Этап 2 - указание как запустить проект
FROM openjdk:17.0.2-jdk
WORKDIR /app
COPY --from=maven /app/target/rabbit_producer-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar app.jar