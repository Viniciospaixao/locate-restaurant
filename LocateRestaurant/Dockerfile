# Imagem base com OpenJDK 17
FROM openjdk:17-jdk-alpine

# Diretório de trabalho no contêiner
WORKDIR /app

# Copia o JAR gerado pelo Maven
COPY target/LocateRestaurant-*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]