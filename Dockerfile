FROM mcr.microsoft.com/playwright/java:v1.42.0-jammy

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

CMD ["mvn", "clean", "test", "-Dheadless=true"]
