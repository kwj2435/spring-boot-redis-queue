FROM openjdk:17-jdk-alpine

COPY target/myapp.jar /app/myapp.jar

CMD ["java", "-jar", "/app/myapp.jar"]

EXPOSE 8080