FROM bellsoft/liberica-openjdk-alpine:17

COPY ./target/application.jar .

ENTRYPOINT ["java","-jar","/application.jar"]