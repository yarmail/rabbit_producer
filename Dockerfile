# Сборка проекта в jar
FROM maven:3.8-openjdk-17 as maven
WORKDIR /app
COPY . /app
RUN mvn install

# Настройка порядка запуска контейнеров
# В ENTRYPOINT запускаем скрипт и добавляем ему параметров
# В в данном случае ожидаем пока запустится сервис rabbitmq
FROM alpine:latest
RUN apk add --no-cache bash
WORKDIR /app
COPY wait-for.sh app/wait-for.sh
RUN chmod +x /wait-for.sh

# Указание как запустить проект
FROM openjdk:17.0.2-jdk
WORKDIR /app
COPY --from=maven /app/target/rabbit_producer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["wait-for.sh", "rabbitmq", "--timeout=20", "--", "java", "-jar", "app.jar"]