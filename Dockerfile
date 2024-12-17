FROM openjdk:17-jdk-alpine

COPY build/libs/spring-boot-redis-queue-0.0.1-SNAPSHOT.jar /app/myapp.jar

CMD ["java", "-jar", "/app/myapp.jar"]

EXPOSE 8080