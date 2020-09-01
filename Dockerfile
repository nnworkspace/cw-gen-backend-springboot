FROM openjdk:8-jdk-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} crossword-gen-backend-springboot-0.0.1-SNAPSHOT.jar

RUN mkdir -p src/main/resources/german/
COPY src/main/resources/german/german.dic src/main/resources/german/german.dic

ENTRYPOINT ["java","-jar","/crossword-gen-backend-springboot-0.0.1-SNAPSHOT.jar"]