# define base docker image
FROM openjdk:11
ADD target/app-neobis.jar app-neobis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-neobis.jar"]