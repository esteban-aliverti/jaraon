FROM maven:3-openjdk-15-slim as build
WORKDIR /code
COPY . /code/
RUN mvn package

FROM openjdk:15.0.2-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build /code/target/quarkus-app/ ./
CMD java -jar *.jar
