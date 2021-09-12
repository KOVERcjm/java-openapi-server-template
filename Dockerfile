FROM maven:3.8.2-openjdk-16 AS builder

COPY src /app/src
COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package


FROM adoptopenjdk/openjdk16:alpine-jre

COPY --from=builder /app/target/myapp-latest.jar /app.jar

EXPOSE 3000

ENTRYPOINT ["java", "-jar", "/app.jar"]
