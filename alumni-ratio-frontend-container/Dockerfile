FROM gradle:7.2.0-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:17.0.2-slim
EXPOSE ${APP_PORT}
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/mi-app-multi-stage.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/mi-app-multi-stage.jar"]