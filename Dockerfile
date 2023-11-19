FROM gradle:7.2.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew init
RUN ./gradlew clean build -x test

FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
