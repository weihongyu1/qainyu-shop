FROM  williamyeh/java8:latest
COPY /shop-web/target/*.jar /app.jar
CMD ["--spring.datasource.password=${DATABASE_PASSWORD}"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
