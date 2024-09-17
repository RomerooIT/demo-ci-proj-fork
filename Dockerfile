FROM openjdk:21
WORKDIR /demo-ci-proj

#RUN ./gradlew clean bootJar
COPY . .
RUN ls -alrt
#COPY ./build/libs/*.jar demo-ci-proj-0.0.1-SNAPSHOT.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "demo-ci-proj-0.0.1-SNAPSHOT.jar"]