FROM openjdk:latest

WORKDIR "/Apps"

COPY ../target/springboot-graphql-0.0.1-SNAPSHOT.war /Apps/springboot-graphql.war

CMD [ "java", "-jar", "/Apps/springboot-graphql.war" ]