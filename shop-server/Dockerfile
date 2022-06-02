FROM  williamyeh/java8:latest
COPY /shop-web/target/*.jar /app.jar
CMD ["--spring.datasource.password=${DATABASE_PASSWORD}"]
CMD ["--spring.profiles.active=${PROFILES}"]
EXPOSE 8089
ENTRYPOINT ["java","-jar","/app.jar"]
