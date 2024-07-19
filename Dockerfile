FROM java:17
EXPOSE 8081
ADD target/produtos .jar
ENTRYPOINT ["java","-jar","produtos.jar"]