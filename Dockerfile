# --- Etapa 1: Build con Maven y JDK 17 ---
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos solo el pom.xml para aprovechar cache de capas en Docker
COPY pom.xml .

# Descargamos dependencias (mejor que hacerlo siempre desde cero)
RUN mvn dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# Construimos el proyecto y generamos el JAR sin correr tests
RUN mvn clean package -DskipTests

# --- Etapa 2: Imagen ligera para runtime con JRE 17 ---
FROM eclipse-temurin:17-jre

# Directorio de trabajo para correr la app
WORKDIR /app

# Copiamos el JAR compilado de la etapa build
COPY --from=build /app/target/*.jar app.jar

# Puerto que exponemos (ajústalo según tu app)
EXPOSE 8080

# Comando para correr la app
CMD ["java", "-jar", "app.jar"]
