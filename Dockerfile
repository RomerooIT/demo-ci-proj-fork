FROM openjdk:21
WORKDIR /demo-ci-proj

#RUN ./gradlew clean bootJar
#COPY . .
RUN ls -alrt
RUN curl -L https://services.gradle.org/distributions/gradle-8.10.1-bin.zip -o gradle-8.10.1-bin.zip
#RUN apt-get update -y && apt-get install -y unzip
RUN unzip gradle-8.10.1-bin.zip
RUN echo 'export GRADLE_HOME=/app/gradle-8.10.1' >> $HOME/.bashrc
RUN echo 'export PATH=$PATH:$GRADLE_HOME/bin' >> $HOME/.bashrc
RUN /bin/bash -c "source $HOME/.bashrc"
RUN ./gradlew bootJar
COPY build/libs/*.jar demo-ci-proj-0.0.1-SNAPSHOT.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "demo-ci-proj-0.0.1-SNAPSHOT.jar"]