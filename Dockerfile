FROM openjdk:8
COPY ./target/attendance-0.0.1-SNAPSHOT.jar attendance-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "attendance-0.0.1-SNAPSHOT.jar"]