FROM amazoncorretto:17.0.0

RUN mkdir /app

COPY target/*.jar /app/app.jar

CMD ["java", "-Djasypt.encryptor.password=5gArdh@8$0Z2","-Dserver.port=9050", "-jar", "/app/app.jar"]