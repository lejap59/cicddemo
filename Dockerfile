FROM openjdk:17

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

copy src ./src

CMD ["./mvnw", "spring-boot:run"]