FROM java:8-jdk-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY target/my-site-0.0.1-SNAPSHOT.jar /usr/src/app/

CMD ["java", "-jar", "my-site-0.0.1-SNAPSHOT.jar"]