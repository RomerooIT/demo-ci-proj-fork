FROM openjdk:21
WORKDIR /demo-ci-proj

#RUN ./gradlew clean bootJar
#COPY . .
RUN ls -alrt
RUN curl -L https://services.gradle.org/distributions/gradle-8.10.1-bin.zip -o gradle-8.10.1-bin.zip && \
    unzip gradle-8.10.1-bin.zip && \
    echo 'export GRADLE_HOME=/app/gradle-8.10.1' >> $HOME/.bashrc && \
    echo 'export PATH=$PATH:$GRADLE_HOME/bin' >> $HOME/.bashrc && \
    /bin/bash -c "source $HOME/.bashrc" && \
    ./gradlew bootJar
#RUN apt-get update -y && apt-get install -y unzip
COPY build/libs/*.jar demo-ci-proj-0.0.1-SNAPSHOT.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "demo-ci-proj-0.0.1-SNAPSHOT.jar"]