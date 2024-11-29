# Etapa de construcción
FROM maven:3.8.1-openjdk-17 AS build

# Copiar archivos necesarios para la construcción
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app

# Compilar el proyecto sin ejecutar las pruebas
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre-jammy

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/employeeProjectService.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Comando de entrada para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "/usr/local/lib/employeeProjectService.jar"]
