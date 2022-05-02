FROM openjdk:17

COPY ./target/application.jar .

CMD ["java","-jar","/application.jar"]