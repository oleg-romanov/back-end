FROM maven:3.6.3-jdk-11

COPY ./ ./

RUN mvn clean package

CMD ["java", "-jar", "target/Toast-1.0-SNAPSHOT.jar"]