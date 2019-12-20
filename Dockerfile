FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./gradlew build --refresh-dependencies
ENTRYPOINT ["java", "-jar", "/app/build/libs/eventlogger-0.0.1-all.jar"]
