FROM openjdk:latest

WORKDIR "/Apps"

COPY ../target/*.war /Apps/springboot-graphql.war

CMD [ "java", "-jar", "/Apps/springboot-graphql.war" ]