FROM openjdk:25-ea-4-jdk-oraclelinux9
LABEL authors="Fady"

WORKDIR /app

COPY /target target/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/massivescale.jar"]