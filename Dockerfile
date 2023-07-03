FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
EXPOSE 8080
COPY target/*.jar ./app.jar
CMD ["bin/sh", "-c", "exec java -jar ${JAVA_OPTS} app.jar"]
