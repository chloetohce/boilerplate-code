`./mvnw clean`
`./mvnw package`
`java -jar <jar file>`
`mvn spring-boot:run`

`mvn spring-boot:run -Dserver.port=3000` (will alter the port used if the port is not set by the app itself)
`mvn spring-boot:run -Dspring-boot.run.arguments="--port=3000 --logLevel=TRACE"`


`java -jar MyApp.jar --port=3000`
`java -Dserver.port=3000 -jar app.jar`