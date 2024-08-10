# Etapa 1: Construcción de la aplicación
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar los archivos de configuración y el código fuente al contenedor
COPY pom.xml .
COPY src ./src

# Compilar la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Construcción de la imagen final
FROM openjdk:17-jdk-slim

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto que usa tu aplicación Spring Boot
EXPOSE 8080

# Establecer el perfil activo a 'prod'
ENV SPRING_PROFILES_ACTIVE prod

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
