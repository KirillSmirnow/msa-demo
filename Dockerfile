FROM eclipse-temurin:21
WORKDIR /opt
ARG folder
COPY $folder/*.jar .
ENTRYPOINT exec java -jar *.jar
