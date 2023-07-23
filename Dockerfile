# Сборка проекта в jar
FROM maven:3.8-openjdk-17 as maven
COPY . .
RUN mvn install


# Указание как запустить проект
# Добавляем скрипт wait-for.sh - после какого сервиса запускать этот
FROM openjdk:17-jdk-alpine3.14
RUN apk add --no-cache bash
COPY wait-for.sh ./wait-for.sh
RUN chmod +x ./wait-for.sh
COPY --from=maven /target/rabbit_producer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["./wait-for.sh", "rabbitmq:15672", "--timeout=20", "--", "java", "-jar", "app.jar"]