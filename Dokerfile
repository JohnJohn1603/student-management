# =========================
# STAGE 1: Build
# =========================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml trước để cache dependency
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests


# =========================
# STAGE 2: Run
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy jar từ stage build
COPY --from=build /app/target/*.jar app.jar

# Render dùng biến môi trường PORT
ENV PORT=8080
EXPOSE 8080

# Start app
ENTRYPOINT ["java", "-jar", "app.jar"]