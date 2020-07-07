FROM openjdk:8u191-jre-alpine3.8

WORKDIR usr/lokesh

ADD target/selenium-docker.jar            selenium-docker.jar
ADD target/selenium-docker-tests.jar      selenium-docker-tests.jar
ADD target/libs                           libs
ADD testng.xml                            testng.xml

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG  testng.xml


