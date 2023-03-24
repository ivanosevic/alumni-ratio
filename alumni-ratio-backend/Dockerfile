FROM maven:3.8.5-openjdk-17-slim as BUILD
WORKDIR /usr/src/app/
COPY src src
COPY pom.xml .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.2-slim
EXPOSE 7000

RUN mkdir /app
COPY --from=build /usr/src/app/target/alumniratiobackend-1-shaded.jar /app/app.jar

ENTRYPOINT ["java", "-jar","/app/app.jar"]

LABEL com.alumni-ratio.version="1.0"
LABEL com.alumni-ratio.name="Alumni Ratio Backend"
LABEL com.alumni-ratio.description="Backend API for Alumni Ratio application"