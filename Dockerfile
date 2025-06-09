FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app


COPY pom.xml .
COPY src ./src


RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jdk
WORKDIR /app


COPY --from=build /app/target/quarkus-app/lib /app/lib
COPY --from=build /app/target/quarkus-app/*.jar /app/
COPY --from=build /app/target/quarkus-app/app /app/app
COPY --from=build /app/target/quarkus-app/quarkus /app/quarkus


EXPOSE 8080

CMD ["java", "-jar", "quarkus-run.jar"]
