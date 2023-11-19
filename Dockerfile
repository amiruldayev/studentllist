FROM gradle:7.2.0-jdk17 AS build
COPY . .
RUN ./gradlew clean build -x test

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /build/libs/studentlist-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]