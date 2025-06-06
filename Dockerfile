# Usa imagen oficial de Maven para build
FROM maven:3.8.6-openjdk-11 AS build

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copia pom.xml y descarga dependencias (cacheable)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copia todo el código fuente
COPY src ./src

# Build del proyecto (generar jar)
RUN mvn clean package -DskipTests

# Imagen runtime ligera con OpenJDK 11
FROM openjdk:11-jre-slim

WORKDIR /app

# Copia el jar desde la etapa build
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que usará la app
EXPOSE 8080

# Comando para ejecutar el jar
CMD ["java", "-jar", "app.jar"]
