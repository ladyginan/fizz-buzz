FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD target/Buzz-1.0-SNAPSHOT.jar target/app.jar

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=local","target/app.jar"]