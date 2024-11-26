# Usar una imagen base válida con Maven y JDK 17
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copiar el código fuente al contenedor
COPY src ./src

# Construir la aplicación
RUN mvn clean package -DskipTests

# Usar una imagen más ligera para ejecutar la aplicación
FROM eclipse-temurin:17-jre

# Configurar el directorio de trabajo
WORKDIR /app

# Copiar el jar generado desde la etapa de build
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar ./app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
