FROM maven:3.8.1-openjdk-11-slim as build

RUN apt-get --yes update
RUN apt-get --yes install git

ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
RUN git clone https://github.com/whoisacat/bookSharingProvider.git

WORKDIR bookSharingProvider
# если развернуть надо из ветки, то надо перейти на ветку (раскомментировать и написать нужную ветку)
#RUN git checkout some_branch
RUN mvn dependency:resolve
RUN mvn install -DskipTests

FROM openjdk:11-jre-slim as lib_app
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

ARG JAR_FILE=$PROJECT_DIR/bookSharingProvider/target/*.jar
COPY --from=build ${JAR_FILE} $PROJECT_DIR/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/project/app.jar"]
