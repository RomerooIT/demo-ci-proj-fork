FROM openjdk:21
WORKDIR /demo-ci-proj
ENTRYPOINT ["cd", "/demo-ci-proj", "&", "./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar demo-ci-proj-0.0.1-SNAPSHOT.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "demo-ci-proj-0.0.1-SNAPSHOT.jar"]