FROM openjdk:17

ADD target/gatewayApi-1.0.0.jar gatewayApi-1.0.0.jar
ADD src/main/resources/routes/auth_routes_v1.json src/main/resources/routes/auth_routes_v1.json
ADD src/main/resources/routes/auth_routes_v1.json src/main/resources/routes/auth_routes_v1.json

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gatewayApi-1.0.0.jar"]
